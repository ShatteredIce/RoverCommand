import java.net.*;
import java.io.*;

public class MainServer {
	
	int portNumber = 567;
	boolean listening = true;
	
	public MainServer() {
		try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
			System.out.println("Server Started");
            while (listening) {
	            new ServerThread(serverSocket.accept()).start();
	        }
	    } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
	}

	public static void main(String[] args) {
		new MainServer();
	}

}
