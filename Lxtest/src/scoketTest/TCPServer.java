package scoketTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//tcp实现
public class TCPServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5505);
			while(true){
				Socket socket = server.accept();
				new ServerThread(socket).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
