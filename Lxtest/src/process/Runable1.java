package process;

public class Runable1 implements Runnable{

	private int i=0;
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				Runable1 r=new Runable1();
				new Thread(r, "新线程1").start();
				new Thread(r, "新线程2").start();
			}
		}		

	}

	@Override
	public void run() {
		for (;i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
	}

}
