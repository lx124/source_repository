package processtest0314;
//能量测试
public class EnergyTest {
	//能量盒子数量 即数组长度
	public static final int BOX_AMOUNT = 100;
	//每个盒子初始能量
	public static final double INITIAL_ENERGY = 1000;
	
	public static void main(String[] args) {
		EnergySystem eng = new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
		for (int i = 0; i < BOX_AMOUNT; i++) {
			EnergyTransferTask task = new EnergyTransferTask(eng, i, INITIAL_ENERGY);
			Thread t = new Thread(task,"TranferThread"+i);
			t.start();
		}

	}

}
