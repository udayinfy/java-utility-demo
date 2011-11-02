package synchronize;

import java.util.Random;

/**
 * ����һ����������ͬ������ͬ��ִ��
 * ������Բ��ԣ�������������˳��ִ�е�
 * 
 * @author Admin
 * 
 */
public class SyncTest2 implements Runnable {

	public int i = 0;

	public synchronized void doMethod1() {
		i = (int) (Math.random() * 1000);
		System.out.println(i);
		//����һ����
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void doMethod2() {
		i = (int) (Math.random() * -1000);
		System.out.println(i);
		// ����һ����
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Random random = new Random();
		while( true ){
			if( random.nextInt() % 2 == 0 )
				doMethod1();
			else
				doMethod2();
		}
	}

	public static void main(String[] args) {
		SyncTest2 r = new SyncTest2();
		Thread t = new Thread(r);
		t.start();
	}

}
