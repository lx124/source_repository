package scoketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket;
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			System.out.println("服务器接收到了客户端的访问");
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while(true){
				String msg = in.readLine();//客户端发来的信息
				System.out.println("客户端给服务器的信息："+msg);
				out.println("server ack"+msg);
				out.flush();
				if(msg.equals("bye")){
					break;
				}
			}
			in.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
}
