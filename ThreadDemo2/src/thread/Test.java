package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Java�̣߳��̳߳�-�Զ����̳߳�
 * 
 * @author Administrator 2009-11-4 23:30:44
 */
public class Test {
	public static void main(String[] args) {
		// �����ȴ�����
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		// ����һ�����߳�ִ�г������ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2,
				TimeUnit.MILLISECONDS, bqueue);
		// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new MyThread2();
		Thread t2 = new MyThread2();
		Thread t3 = new MyThread2();
		Thread t4 = new MyThread2();
		Thread t5 = new MyThread2();
		Thread t6 = new MyThread2();
		Thread t7 = new MyThread2();
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

class MyThread extends Thread {
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