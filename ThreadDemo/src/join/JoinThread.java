package join;

/***
 * join�����Ĺ��ܾ���ʹ�첽ִ�е��̱߳��ͬ��ִ�С�<br>
 * 100���߳���������߳���ͬ��ִ�еġ�
 * 
 * @author Admin
 * 
 */
public class JoinThread extends Thread {

	static int num = 0;

	static synchronized void add1() {
		num++;
	}

	@Override
	public void run() {
		super.run();

		for (int i = 0; i < 10; i++) {
			add1();
			System.out.println(getName() + " " + i);
			try {
				sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new JoinThread();
			threads[i].setName("thread" + i);
		}
		for (int i = 0; i < threads.length; i++)
			threads[i].start();

		for (int i = 0; i < threads.length; i++)
			threads[i].join();

		System.out.println(num);

	}

}
