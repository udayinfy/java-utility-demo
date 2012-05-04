package thread.java5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	public static void main(String[] args) {
		// �����ȴ�����
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		// ����һ�����߳�ִ�г������ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2, TimeUnit.MILLISECONDS, bqueue);
		// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new Thread3();
		Thread t2 = new Thread3();
		Thread t3 = new Thread3();
		Thread t4 = new Thread3();
		Thread t5 = new Thread3();
		Thread t6 = new Thread3();
		Thread t7 = new Thread3();
		// ���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.execute(t7);
		// �ر��̳߳�
		pool.shutdown();
	}
}

class Thread3 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ�С�����");
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}