package join;

/***
 * join方法的功能就是使异步执行的线程变成同步执行。<br>
 * 100个线程相对于主线程是同步执行的。
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
