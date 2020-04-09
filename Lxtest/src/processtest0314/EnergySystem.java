package processtest0314;
//能量系统 能量守恒 不会消失 会从一处转移到另一处
public class EnergySystem {
	
	//能量盒子 储存能量地方
	private final double[] energyBoxs;
	private Object lockObj = new Object();
	/**
	 * 
	 * @param n 能量盒子数量
	 * @param initialEnergy 每个盒子初始值
	 */
	public EnergySystem(int n,double initialEnergy){
		energyBoxs = new double[n];
		for (int i = 0; i < energyBoxs.length; i++) {
			energyBoxs[i] = initialEnergy;
		}
	}
	/**
	 * 能量转移 从一个盒子转移到另一个盒子
	 * @param from 能量值
	 * @param to   能量终点
	 * @param amount 能量值
	 */
	public void transfer(int from,int to,double amount){
		synchronized (lockObj) {
//			if(energyBoxs[from] < amount)
//				return;
			//while 循环 ，保证条件不满足时任务会被条件阻挡
			//而不是继续竞争cpu资源
			//wait set
			while(energyBoxs[from] < amount){
				try {
					lockObj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName());
			energyBoxs[from] -= amount;
			System.out.printf("从%d转移%10.2f能量到%d",from,amount,to);
			energyBoxs[to] += amount;
			System.out.printf("能量总和：%10.2f%n",getTotalEnergies());
			//唤醒所有在locakObj上等待的线程
			lockObj.notifyAll();//
		}
		
	}
	/**
	 * 计算能量总和
	 * @return
	 */
	public double getTotalEnergies(){
		double sum = 0;
		for (double d : energyBoxs) {
			sum += d;
		}
		return sum;
	}
	/**
	 * 返回能量盒子长度
	 */
	public int getBoxAmount(){
		return energyBoxs.length;
	}
}
