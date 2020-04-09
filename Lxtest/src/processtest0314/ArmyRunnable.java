package processtest0314;
//军队 模拟作战双方
public class ArmyRunnable implements Runnable {
	//volatile 保证了线程可以正确读取其他线程写入的值
	//可见性 ref JMM ,happens-before原则
	volatile boolean keepRunning = true;
//	private int i;
	@Override
	public void run() {
		while(keepRunning){
			//发动5连击
			for (int i=0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
				//让出当前线程处理器时间 下次谁进攻不一定 
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName()+"结束战斗");
	}

}
