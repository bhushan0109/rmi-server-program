package client_server_program_01_10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class server {

	public static void main(String[] args) {
		ServerSocket obj_server_soc = null;
		int client_counter = 0;
		Scanner sc = new Scanner(System.in);
		try {

			// Creating Server socket on the port 1234.
			obj_server_soc = new ServerSocket(1234);
			obj_server_soc.setReuseAddress(true);

			System.out.println("The Server is running...");

			String line = null;
			// infinite loop for client connection requests
			while (!"quit".equalsIgnoreCase(line)) {

				client_counter = client_counter;

				// Instantiating a new thread for every new client request.

				// This thread will handle all the requestes from the client.
				System.out.println("Please enter members/quit");

				if (sc.hasNextLine()) {
					line = sc.nextLine();
				}
				if (line.equalsIgnoreCase("quit") || line.isEmpty()) {
					System.out.println("Disconnecting server");
					obj_server_soc.close();
					break;
				} else if (line.equalsIgnoreCase("members")){
					System.out.println("members count ==>" + client_counter);

				}else {
					
					Socket client = obj_server_soc.accept();
					client_counter = client_counter + 1;

					// Instantiating a new thread for every new client request.
					ClientHandler clientSock = new ClientHandler(client, client_counter);

					// This thread will handle all the requestes from the client.
					new Thread(clientSock).start();
					
					
				}
				
				
				
				
				
				
				

				// socket object to receive incoming client requests

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
