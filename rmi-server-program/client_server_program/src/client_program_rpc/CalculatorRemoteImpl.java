package client_program_rpc;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CalculatorRemoteImpl implements Calculator {
//    public static final int PORT = 9091;
 
    public int add(int a, int b,Socket socket) {

        try {

            CalculateRpcRequest calculateRpcRequest = generateRequest(a, b);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(calculateRpcRequest);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object response = objectInputStream.readObject();

            if (response instanceof Integer) {

                return (Integer) response;
                
            } else {
                throw new InternalError();
                
            }
            
        } catch (Exception e) {
         e.printStackTrace();
            throw new InternalError();
        }       
    }

    private CalculateRpcRequest generateRequest(int a, int b) {
        CalculateRpcRequest calculateRpcRequest = new CalculateRpcRequest();
        calculateRpcRequest.setA(a);
        calculateRpcRequest.setB(b);
        calculateRpcRequest.setMethod("add");
        return calculateRpcRequest;
    }

}
