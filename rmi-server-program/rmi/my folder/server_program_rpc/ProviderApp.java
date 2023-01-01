

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ProviderApp {
// private static Calculator calculator = new CalculatorImpl();
	public static void main(String[] args) {
		ServerSocket obj_server_soc = null;
		int client_counter = 0;
		try {

			// Creating Server socket on the port 1234.
			obj_server_soc = new ServerSocket(1234);
			obj_server_soc.setReuseAddress(true);

			System.out.println("The Server is running...");

			// infinite loop for client connection requests
			while (true) {

				// socket object to receive incoming client requests
				Socket client = obj_server_soc.accept();
				client_counter = client_counter + 1;

				// Printing the Newly connected client info on the console.
				System.out.println("Hello, you are client #" + client_counter);

				// Instantiating a new thread for every new client request.
				ClientHandler clientSock = new ClientHandler(client, client_counter);

				// This thread will handle all the requestes from the client.
				new Thread(clientSock).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (obj_server_soc != null) {
				try {
					obj_server_soc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ClientHandler class
	private static class ClientHandler implements Runnable {
		private final int client_number;
		private final Socket clientSocket;

		public ClientHandler(Socket socket, int client_number) {
			this.clientSocket = socket;
			this.client_number = client_number;
		}

		public void run() {
			PrintWriter out = null;
			BufferedReader in = null;
			try {

				// Instance of Print writer to send response to the client.
				out = new PrintWriter(clientSocket.getOutputStream(), true);

				// Input stream to read messages from the client.
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				String line;
				while ((line = in.readLine()) != null) {

					if (line.isEmpty()) {
						System.out.println("Client #" + this.client_number + " got disconnected..");
						break;
					}
					// Printing the message received from client.
					System.out.println("Message received from client #" + this.client_number + " :" + line);

					if (line.equals("time")) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();

						// Reply to client
						String response = dtf.format(now);
						out.println(response);
					} else if (line.equals("add")) {
						//out.println("additon");
						
						 try {
				                // 
							   	System.out.println("add calling");
							 
				                ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
				                Object object = objectInputStream.readObject();

				                // 
				                int result = 0;
				                if (object instanceof CalculateRpcRequest) {
				                    CalculateRpcRequest calculateRpcRequest = (CalculateRpcRequest) object;
				                    if ("add".equals(calculateRpcRequest.getMethod())) {
				                    	Calculator calculator = new CalculatorImpl();
				                        result = calculator.add(calculateRpcRequest.getA(), calculateRpcRequest.getB());
				                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
						                objectOutputStream.writeObject(new Integer(result));
						                line=""+result;
				                     	out.println(line);
				                    } else {
				                        throw new UnsupportedOperationException();
				                    }
				                }else {

				                	out.println("wrong input");
				                }

				            } catch (Exception e) {
				            	System.out.println("error!");
				            	e.printStackTrace();
				            } 
						 
					} else {
						out.println(line.toUpperCase(Locale.ROOT));
					}
				}
				out.close();
				in.close();
				this.clientSocket.close();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
						clientSocket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
