package iotest0223;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//字节字符转换流 字符流操作的是文本文件
public class IsrAndOsw {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream("e:/aaa/哈哈.txt");
		FileOutputStream out = new FileOutputStream("e:/aaa/a.txt");
		//有编码问题 默认项目编码
		InputStreamReader isr = new InputStreamReader(in,"gbk");
		
		OutputStreamWriter osw = new OutputStreamWriter(out,"gbk");
//		int c;
//		while((c = isr.read())!=-1){
//			System.out.print((char)c);
//		}
		char[] buffer = new char[8*1024];
		int c;
		//批量读取 放入字符数组 从0放 最多放buffer.leng个 返回读取的字符数
		while((c=isr.read(buffer, 0, buffer.length))!=-1){
			String s = new String(buffer, 0, c);
			System.out.println(s);
			osw.write(buffer,0,c);
			osw.flush();
		}
		isr.close();
		osw.close();
	}

}
