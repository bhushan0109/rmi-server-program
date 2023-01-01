package client_program_rpc;

import java.net.Socket;

public interface Calculator {
    int add(int a, int b,Socket socket);
    
}
