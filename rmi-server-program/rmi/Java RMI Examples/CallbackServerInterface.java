import java.rmi.*;

/**
 * This is a remote interface for illustrating RMI client callback.
 * 
 * @author M. L. Liu
 */

public interface CallbackServerInterface extends Remote {

	public int action(int x, int y) throws java.rmi.RemoteException;

	public String action(String line) throws java.rmi.RemoteException; 

// This remote method allows an object client to 
// register for callback
// @param callbackClientObject is a reference to the
//        object of the client; to be used by the server
//        to make its callbacks.

	public void registerForCallback(CallbackClientInterface callbackClientObject) throws java.rmi.RemoteException;

// This remote method allows an object client to 
// cancel its registration for callback

	public void unregisterForCallback(CallbackClientInterface callbackClientObject) throws java.rmi.RemoteException;
}