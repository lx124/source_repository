package iotest0223;

import java.io.IOException;
import java.io.Serializable;

//对象序列化用
public class StudentEntity implements Serializable{
	private String stuno;
	private transient int stuage;//该元素不会进行jvm默认的序列化 也可以自己完成这个元素序列化
	//网络传输浪费流量和时间 返序列化后为默认值0
	private String stuname;
	public StudentEntity(){
	}
	
	public StudentEntity(String stuno, int stuage, String stuname) {
		super();
		this.stuno = stuno;
		this.stuage = stuage;
		this.stuname = stuname;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public int getStuage() {
		return stuage;
	}

	public void setStuage(int stuage) {
		this.stuage = stuage;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	@Override
	public String toString() {
		return "StudentEntity [stuno=" + stuno + ", stuage=" + stuage + ", stuname=" + stuname + "]";
	}
	
	private void writeObject(java.io.ObjectOutputStream s) throws IOException{
		s.defaultWriteObject();//把jvm默认的能序列化的序列化
		s.writeInt(stuage);//自己完成stuage 序列化
	}
	private void readObject(java.io.ObjectInputStream s) throws IOException,ClassNotFoundException{
		s.defaultReadObject();//把虚拟机默认的反序列化进行反序列化操作
		this.stuage=s.readInt();//自己完成反序列化操作
	}
	
}
