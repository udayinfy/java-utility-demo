package join;

/**
 * 测试线程没有启动时调用join方法，结果，被调用的线程对象什么也没有发生<br>
 * 测试线程结束时调用join方法，结果，执行结束的线程什么也没有发生
 * 
 * @author Admin
 * 
 */
public class JoinTest extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new JoinTest();
		// thread.start();

		thread.join();

		// Thread.sleep(3000);

		// thread.join();

		System.out.println("main thread finish. ");

	}

}
