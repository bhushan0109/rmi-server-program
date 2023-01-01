import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MethodRemote extends UnicastRemoteObject implements Method {

	protected MethodRemote() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int action(int x, int y) throws RemoteException {
		return x + y;
	}

	@Override
	public String action(String line) throws RemoteException {
		if (line.equals("time")) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			// Reply to client
			return dtf.format(now);
		} else {
			return line.toUpperCase(Locale.ROOT);
		}
	}
}