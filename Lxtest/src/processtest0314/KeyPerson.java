package processtest0314;
//关键人物 出场
public class KeyPerson extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始了战斗!!!");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"攻击隋军，无人可当!!["+i+"]");
		}
		System.out.println(Thread.currentThread().getName()+"结束了战斗!!!");
	}
}
