package exceptionTest0406;
//异常链
public class ChainTest {

	public static void main(String[] args) {
		ChainTest ct = new ChainTest();
		try {
			ct.test2();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void test1() throws DefineException{
		throw new DefineException("喝大了");
	}
	public void test2() {
		try {
			test1();
		} catch (DefineException e) {
			RuntimeException newExc = new RuntimeException(e);
//			newExc.initCause(e);
			throw newExc;
		}
	}
}
