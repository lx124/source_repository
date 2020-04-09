package iotest0223;

import java.io.File;
import java.io.IOException;

//列出file的一些常用操作
public class FileUntil {
	/**
	 * 列出指定目录下所有文件(包含子目录)
	 * @param dir
	 * @throws IOException
	 * @throws IllegalAccessException 
	 */
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录");
		}
		String[] listName=dir.list();//字符串数组 文件名 不包含子目录下内容
		for (String str : listName) {
			System.out.println(dir+File.separator+str);
		}
		File[] files=dir.listFiles();//返回file对象
		if(files!=null && files.length>0){
			for (File file : files) {
				if(file.isDirectory()){
					listDirectory(file);//递归
				}else{
					System.out.println(file);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		try {
			listDirectory(new File("e:/歌学"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
