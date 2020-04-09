package iotest0223;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File demo=new File("demo");
		if(!demo.exists()){
			demo.mkdir();
		}
		File file=new File("demo","raf.txt");
		if(!file.exists())
			file.createNewFile();
		
		RandomAccessFile raf=new RandomAccessFile(file, "rw");
		//指针位置
		System.out.println(raf.getFilePointer());
		raf.write('A');//只写了1个字节
		System.out.println(raf.getFilePointer());
		raf.write('B');//只写了1个字节
		System.out.println(raf.getFilePointer());
		int i=0x7fffffff;
		//用write 方法每次写一个，写i用4次
		raf.write(i>>>24);//高8位
		raf.write(i>>>16);
		raf.write(i>>>8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		//可以直接写一个int 
		raf.writeInt(i);//同上
		String s="中";
		byte[] utf8=s.getBytes();//3个字节
		raf.write(utf8);
		System.out.println(raf.getFilePointer());
		//读文件 必须把指针移到头部
		raf.seek(0);
		//一次性读取 把文件中内容读到字节数组 
		byte[] buff=new byte[(int)raf.length()];//大小一样
		raf.read(buff);
		System.out.println(Arrays.toString(buff));
//		String ss=new String(buff,"UTF-8");
//		System.out.println(ss);
		for (byte b : buff) {
			System.out.print(Integer.toHexString( b&0xff)+" ");
		}
		raf.close();
	}

}
