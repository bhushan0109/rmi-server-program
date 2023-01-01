package client_program_rpc;

import java.io.*;
import java.net.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.*;

public class ConsumerApp {

	// driver code
	public static void main(String[] args) throws NotBoundException {
		// Instantiating scanner class for reading input from console.
		Scanner sc = new Scanner(System.in);
		// Reading IP address from user.
//		System.out.println("Please enter server IP address");
//		String host = sc.nextLine();

		// Reading port number from user.
		System.out.println("Please enter server port Number");
		int port = Integer.parseInt(sc.nextLine());

		// Connecting to the server with provided IP address and port.
		try {

			// Printer object tot send messages to the Server.
//			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			// Buffer reader instance to read response from Server.
//			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = null;
			while (!"exit".equalsIgnoreCase(line)) {
				System.out.println("Please enter message to send to the Server...");
				// reading message from user.

				if (sc.hasNextLine()) {
					line = sc.nextLine();
				}
				// Condition to close the server connection if user enters an empty string.
				if (line.isEmpty() || line.equalsIgnoreCase("no")) {
					System.out.println("Disconnecting from server");
//					out.println(line);
//					out.flush();
					break;
				} else if (line.equalsIgnoreCase("add")) {
					System.out.println("Please enter first number...");
					int a = sc.nextInt();

					System.out.println("Please enter second number...");
					int b = sc.nextInt();
//					out.println(line);
//					out.flush();
//					Calculator calculator = new CalculatorRemoteImpl();
//					int result = calculator.add(a, b, socket);
//					//line = "result";
//					System.out.println("addition "+result);
//				//	out.println(line);
//				//	System.out.println("--"+line);
//					out.flush();

					Method stub = (Method) Naming.lookup("rmi://192.168.43.91:5000/lab6"); // replace 35.39.165.77 with
																							// your
					// server's IP address
					System.out.println(stub.action(a, b));

					System.out.println("Do you want to continue type yes or no");
					line = sc.nextLine();
				} else {
//					out.println(line);
//					out.flush();
					Method stub = (Method) Naming.lookup("rmi://192.168.43.91:5000/lab7"); 
					System.out.println(stub.action(line));
				}
				// displaying server reply
//				System.out.println("Server replied " + in.readLine());
				line.trim();
				// System.out.println(line.trim());
			}

			// closing the scanner object
			sc.close();
//			out.close();
//			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
