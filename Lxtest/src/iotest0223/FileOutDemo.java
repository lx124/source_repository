package iotest0223;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo {

	public static void main(String[] args) {
		try {
			outFile("demo/raf.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void outFile(String fileName) throws IOException{
		//输出流如果不选择追加 则先如果文件不存在则创建 如果存在先删除再创建
//		FileOutputStream out = new FileOutputStream("E:aaa/io.java");
	
		FileOutputStream out = new FileOutputStream(fileName,true);
		out.write('1');
		out.write('A');
		int a=10;//一个整数4个字节 所以写整数用4次 每次低8位
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] bs="中国".getBytes("gbk");
		out.write(bs);
		out.close();
		IOUntiol.printHexByByte("demo/raf.txt");
	}

}
