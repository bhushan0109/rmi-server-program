package client_program_rpc;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class MethodRemote extends UnicastRemoteObject implements Method {

	MethodRemote() throws RemoteException {
		super();
	}

	public int action(int x, int y) {
		return x + y;
	}

	@Override
	public String action(String line) {
		// TODO Auto-generated method stub
		return null;
	}
}
