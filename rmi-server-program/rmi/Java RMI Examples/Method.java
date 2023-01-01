import java.rmi.*;
import java.rmi.server.*;

public interface Method extends Remote {

	public int action(int x, int y) throws RemoteException;

	public String action(String line) throws RemoteException; 
}
