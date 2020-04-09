package iotest0223;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		DataOutputStream dos = new  DataOutputStream(new FileOutputStream("demo/raf.txt"));
		dos.writeInt(10);
		dos.writeInt(-10);
		dos.writeLong(10l);
		dos.writeDouble(10.5);
		dos.writeUTF("中国");//utf-8输出
		dos.writeChars("加油");//utf16-be
		
		dos.close();
		IOUntiol.printHex("demo/raf.txt");
//		byte a=-127;
//		System.out.println(Integer.toHexString(a&0xff) );
	}

}
