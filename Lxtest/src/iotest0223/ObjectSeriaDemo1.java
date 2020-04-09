package iotest0223;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//对象序列化操作
public class ObjectSeriaDemo1 {

	public static void main(String[] args) throws Exception{
		String file = "demo/obj.txt";
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));//把对象转换字节
		StudentEntity stu = new StudentEntity("10010", 23,"张三");
		oos.writeObject(stu);//保存到文件 以字节方式
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(file));
		StudentEntity stu1 = (StudentEntity)ois.readObject();//强制转换
		System.out.println(stu1);
		ois.close();
	}

}
