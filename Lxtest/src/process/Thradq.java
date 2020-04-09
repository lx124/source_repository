package process;

public class Thradq extends Thread{

	private int j;
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+"  "+i);
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20){
				new Thradq().start();
				new Thradq().start();
			}
		}

	}

}
