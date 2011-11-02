package other;

/**
 * �̵߳��ĸ�״̬�����������У����𣬽���<br>
 * ��ʾ����ʾ����ͻ����߳�<br>
 * ����wait��notify�������̴߳��ڹ���ͻ���״̬
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
		
		sleepThread.start(); // ��ʼ�����߳�sleepThread
		sleepThread.join(); // ʹ�߳�sleepThread�ӳ�2��
		
		thread.start();
		boolean flag = false;
		while (true) {
			sleep(5000); // ʹ���߳��ӳ�5��
			flag = !flag;
			if (flag)
				thread.suspend();
			else
				thread.resume();
		}
	}
}