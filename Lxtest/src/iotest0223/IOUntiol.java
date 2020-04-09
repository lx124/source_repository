package iotest0223;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**工具类
 * io
 * @author asus
 *
 */
public class IOUntiol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			printHex("E:/aaa/哈哈.txt");
//			printHexByByte("E:/aaa/io.java");
//			copy(new File("E:/aaa/哈哈.txt"), new File("E:/aaa/哈哈1.txt"));
			copyByBuffer(new File("E:/aaa/哈哈.txt"), new File("E:/aaa/哈哈3.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//读取文件指定内容 按照16进制输出到控制台
	public static void printHex(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i=1;
		while((b = in.read())!=-1){
			if(b < 0xf){
				//单位数前面补0
				System.out.print(0);
			}
//			i++;
//			System.out.print(Integer.toHexString(b)+"  "+i+"/ ");
			System.out.print(Integer.toHexString(b& 0xff) +"  ");
			if(i++%10==0){
				System.out.println();
			}
		}
		in.close(); 
	}
	//读取文件指定内容 按照16进制输出到控制台 通过字节数组
	public static void printHexByByte(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];//20k
		int bytes = in.read(buf, 0, buf.length);
		int j=1;
		for (int i = 0; i < bytes; i++) {
			if((buf[i]) < 0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(buf[i] & 0xff) +"  ");
			if(j++%10==0){
				System.out.println();
			}
		}
		in.close();
	}
	//复制文件 不带缓冲 一个字节一个字节方式
		public static void copyByByte(File srcFile,File destFile)throws IOException{
			if(!srcFile.exists()){
				throw new IllegalArgumentException("文件"+srcFile+"不存在");
			}
			if(!destFile.exists()){
				throw new IllegalArgumentException("文件"+destFile+"不存在");
			}
			FileInputStream in = new FileInputStream(srcFile);
			FileOutputStream out = new FileOutputStream(destFile);
			int b;
			while((b=in.read())!=-1){
				out.write(b);
				out.flush();//最好加上
			}
			
			in.close();
			out.close();
		}
	//复制文件 不带缓冲 字节数组方式
	public static void copy(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件"+srcFile+"不存在");
		}
		if(!destFile.exists()){
			throw new IllegalArgumentException("文件"+destFile+"不存在");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[8*1024];
		int b;
		while((b=in.read(buf, 0, buf.length))!=-1){
			out.write(buf,0,b);
			out.flush();//最好加上
		}
		
		in.close();
		out.close();
	}
	//复制文件 用字节缓冲流
		public static void copyByBuffer(File srcFile,File destFile)throws IOException{
			if(!srcFile.exists()){
				throw new IllegalArgumentException("文件"+srcFile+"不存在");
			}
//			if(!destFile.exists()){
//				throw new IllegalArgumentException("文件"+destFile+"不存在");
//			}
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
			int c;
			while((c = bis.read())!=-1){
				bos.write(c);
				bos.flush();//刷新缓冲区  必须写 否则写入不到缓冲区中去
			}
			bis.close();
			bos.close();
		}
}
