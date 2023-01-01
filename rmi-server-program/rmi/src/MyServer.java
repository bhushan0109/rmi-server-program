import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class MyServer {

	public static void main(String args[]) {
		try {
			MethodRemote stub = new MethodRemote();
			Naming.rebind("rmi://localhost:5000/lab7", stub);
			Naming.rebind("rmi://localhost:5000/lab6", stub); // replace 35.39.165.77 with your server's IP address
			System.out.println("The RMI Server is running!");

			CallbackServerImpl exportedObj = new CallbackServerImpl();
			Naming.rebind("rmi://localhost:5000/lab8", exportedObj);
			Naming.rebind("rmi://localhost:5000/lab9", exportedObj);
			System.out.println("The Callback Server is running!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
