package iotest0223;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DisDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		DataInputStream dis = new DataInputStream(new FileInputStream("demo/raf.txt"));
		
		int i = dis.readInt();
		System.out.println(i);
		i = dis.readInt();
		long l = dis.readLong();
		System.out.println(i);
		double d = dis.readDouble();
		System.out.println(d);
		String s = dis.readUTF();
		System.out.println(s);
		dis.close();
	}

}
