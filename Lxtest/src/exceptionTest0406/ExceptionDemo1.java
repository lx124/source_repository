package exceptionTest0406;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		int result = new ExceptionDemo1().testReturn();
		System.out.println("程序结束，返回值："+result);
	}
	public int testReturn(){
		Scanner in = new Scanner(System.in);
		int result;
		try {
			System.out.println("输入第一个数");
			int one = in.nextInt();
			System.out.println("输入第二个数");
			int two = in.nextInt();
			System.out.println("运算结果"+ one/two);
			result = one/two;
		} catch (InputMismatchException e) {
			System.out.println("你应该输入整数");
			result =  0;
		} catch (ArithmeticException e) {
			System.out.println("除数不能为0");
			e.printStackTrace();
			result =  0;
		} finally {
			System.out.println("调用方法运行完毕");
		}
		return result;
	}
}
