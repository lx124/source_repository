package processtest0314;

public class LxThreadTest {

	public static void main(String[] args) {
		Thread a = new A();
		a.setName("A");
		a.start();
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+"循环第"+i+"次");
		}
		System.out.println(Thread.currentThread().getName()+"结束!!!");
	}

}
class A extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+"循环第"+i+"次");
			if(i%5 == 0 && i != 0){
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束!!!");
	}
}
