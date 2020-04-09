package scoketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//实现tcp连接 客户端
public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 5505);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);

//			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			while(true){
//				String msg = reader.readLine();
				String msg = sc.nextLine();
				out.println(msg);
				out.flush();
				if(msg.equals("bye")){
					break;
				}
				System.out.println(in.readLine());
			}
			
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
