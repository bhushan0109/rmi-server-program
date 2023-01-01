package client_server_program_01_10;

import java.io.*;
import java.net.*;
import java.util.*;

public class client2 {

    // driver code
    public static void main(String[] args)
    {
        // Instantiating scanner class for reading input from console.
        Scanner sc = new Scanner(System.in);

        // Reading IP address from user.
        System.out.println("Please enter server IP address");
        String host = sc.nextLine();

        // Reading port number from user.
        System.out.println("Please enter server port Number");
        int port = Integer.parseInt(sc.nextLine());

        // Connecting to the server with provided IP address and port.
        try (Socket socket = new Socket(host, port)) {

            // Printer object tot send messages to the Server.
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // Buffer reader instance to read response from Server.
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            String line = null;
            while (!"exit".equalsIgnoreCase(line)) {
                System.out.println("Please enter message to send to the Server...");
                // reading message from user.
                if(sc.hasNextLine()){
                    line = sc.nextLine();
                }

                // Condition to close the server connection if user enters an empty string.
                if(line.isEmpty()){
                    System.out.println("Disconnecting from server");
                    out.println(line);
                    out.flush();
                    break;
                }

                //Sending user data to the Server.
                out.println(line);
                out.flush();

                // displaying server reply
                System.out.println("Server replied "
                        + in.readLine());
            }

            // closing the scanner object
            sc.close();
            out.close();
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
