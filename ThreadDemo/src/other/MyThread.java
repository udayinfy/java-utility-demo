package other;

/**
 * 线程的四个状态，创建，运行，挂起，结束<br>
 * 此示例演示挂起和唤醒线程<br>
 * 此外wait和notify可以让线程处于挂起和唤醒状态
 * @author Admin
 *
 */
public class MyThread extends Thread {
	
	class SleepThread extends Thread {
		public void run() {
			try {
				sleep(2000);
			} catch (Exception e) {
			}
		}
	}

	public void run() {
		while (true)
			System.out.println(new java.util.Date().getTime());
	}

	public static void main(String[] args) throws Exception {
		
		MyThread thread = new MyThread();
		SleepThread sleepThread = thread.new SleepThread();
		
		sleepThread.start(); // 开始运行线程sleepThread
		sleepThread.join(); // 使线程sleepThread延迟2秒
		
		thread.start();
		boolean flag = false;
		while (true) {
			sleep(5000); // 使主线程延迟5秒
			flag = !flag;
			if (flag)
				thread.suspend();
			else
				thread.resume();
		}
	}
}