package thread.java5;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class FixedThreadPool {
	
	public static void main(String[] args) {
		// ����һ�������ù̶��߳������̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(32);
		// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new Thread1();
		Thread t2 = new Thread1();
		Thread t3 = new Thread1();
		Thread t4 = new Thread1();
		Thread t5 = new Thread1();
		// ���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		// �ر��̳߳�
//		pool.shutdown();
	}
	
}

class Thread1 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ�С�����");
	}
}