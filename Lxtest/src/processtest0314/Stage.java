package processtest0314;
//隋唐演义大戏舞台
public class Stage extends Thread {
	
	@Override
	public void run() {
		System.out.println("大幕拉开，演出即将开始");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
//		ArmyRunnable suiDynasy = new ArmyRunnable();
//		ArmyRunnable ofRevolt = new ArmyRunnable(); 
		
//		Thread armySuiDynasy = new Thread(suiDynasy,"隋军");
//		Thread armyOfRevolt = new Thread(ofRevolt,"农民起义军");
		ArmyRunnable jun = new ArmyRunnable(); 
		Thread armySuiDynasy = new Thread(jun,"隋军");
		Thread armyOfRevolt = new Thread(jun,"农民起义军");
		//启动线程 让军队开始作战
		armySuiDynasy.start();
		armyOfRevolt.start();
		//舞台线程休眠 大家专心观看军队打架
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("此时，半路杀出了个程咬金!!!");
		Thread mrCheng = new KeyPerson();
		mrCheng.setName("程咬金");
		System.out.println("英雄登场!!!");
//		suiDynasy.keepRunning = false;
//		ofRevolt.keepRunning = false;
		jun.keepRunning = false;
		mrCheng.start();
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("战争结束，英雄改变了战场");
		System.out.println("演出结束");
	}
	public static void main(String[] args) {
		new Stage().start();
	}

}
