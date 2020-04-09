package iotest0223;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("e:/aaa/哈哈.txt"); 
		FileWriter fw = new FileWriter("e:/aaa/aa.txt");
		int c;
		char[] buf = new char[2056];
		while((c=fr.read(buf, 0, buf.length))!=-1){
			fw.write(buf,0,c);
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
