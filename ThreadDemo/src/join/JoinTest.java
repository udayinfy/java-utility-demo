package join;

/**
 * �����߳�û������ʱ����join����������������õ��̶߳���ʲôҲû�з���<br>
 * �����߳̽���ʱ����join�����������ִ�н������߳�ʲôҲû�з���
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
