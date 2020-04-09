package iotest0223;

import java.io.File;
import java.io.IOException;
//io流大计划

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("E:/aaa");
//		File f=new File("E:"+File.separator+"aaa");//分隔符 win和其他系统都认识
//		System.out.println("判断目录存在与否"+file.exists());
//		if (!file.exists()){
//			file.mkdir();//创建目录
//		} else {
//			file.delete();//删除目录
//		}
		System.out.println("判断是否是目录"+file.isDirectory());//目录不存在返回false
		System.out.println("判断是否是文件"+file.isFile());
		
		File f1=new File("e:/aaa/哈哈.txt");
		if(!f1.exists()){//判断文件是否存在
			try {
				f1.createNewFile();//创建文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			f1.delete();
		}
	}
	

}
