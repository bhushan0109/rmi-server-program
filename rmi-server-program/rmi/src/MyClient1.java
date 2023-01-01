import java.rmi.*;
import java.util.Scanner;

import java.io.*;

public class MyClient1 {

	public static void main(String args[]) {
		try {

			Scanner sc = new Scanner(System.in);
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
					break;
				} else if (line.equalsIgnoreCase("YES")) {
					continue;

				} else if (line.equalsIgnoreCase("add")) {
					System.out.println("Please enter first number...");
					int a = sc.nextInt();

					System.out.println("Please enter second number...");
					int b = sc.nextInt();

					Method stub = (Method) Naming.lookup("rmi://localhost:5000/lab6");
					// your
					System.out.println(stub.action(a, b));

					CallbackServerInterface h = (CallbackServerInterface) Naming.lookup("rmi://localhost:5000/lab9");
					System.out.println(h.action(a, b));
					CallbackClientInterface callbackObj = new CallbackClientImpl();
					// register for callback
					h.registerForCallback(callbackObj);
					h.unregisterForCallback(callbackObj);

					System.out.println("Do you want to continue type yes or no");
					line = sc.nextLine();
				} else {

					Method stub = (Method) Naming.lookup("rmi://localhost:5000/lab7");
					System.out.println(stub.action(line));

					CallbackServerInterface h = (CallbackServerInterface) Naming.lookup("rmi://localhost:5000/lab9");
					System.out.println(h.action(line));
					CallbackClientInterface callbackObj = new CallbackClientImpl();
					// register for callback
					h.registerForCallback(callbackObj);
					h.unregisterForCallback(callbackObj);

				}

				line.trim();
			}

			// closing the scanner object
			sc.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
