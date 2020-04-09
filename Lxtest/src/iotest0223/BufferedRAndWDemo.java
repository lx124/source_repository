package iotest0223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//字符缓冲流
public class BufferedRAndWDemo {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						//必须原文件编码格式一致
						new FileInputStream("e:/aaa/哈哈.txt"),"gbk"));
		//可以用printWriter 代替bufferedWriter 构造简单
		PrintWriter pw = new PrintWriter("e:/aaa/哈哈5.txt");
		
		BufferedWriter bw = new BufferedWriter(
				new  OutputStreamWriter(
						new FileOutputStream("e:/aaa/哈哈3.txt")));
		String line;
		while((line = br.readLine())!=null){
			System.out.println(line);
//			bw.write(line);
//			//单独写出换行
//			bw.newLine();
//			bw.flush();
			pw.println(line);
			pw.flush();
		}
		br.close();
		bw.close();
		pw.close();

	}

}
