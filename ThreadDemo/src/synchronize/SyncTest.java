package synchronize;


/**
 * ���� synchronized ͬ����������������
 * һ���߳���סһ�������Ժ�
 * �����߳�Ҫ�ȵ����߳�ִ����ſ���ִ�С�
 * @author Admin
 *
 */
public class SyncTest extends Thread {

	
	public static synchronized void print() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println( i );
		}

	}

	@Override
	public void run() {

		print();

	}
	
	public static void main(String[] args) {
		
		Thread[] threads = new Thread[10];
		
		for( int i=0; i<threads.length; i++ ) {
			threads[i] = new SyncTest();
			threads[i].setName( "Thread" + i );
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		System.out.println( "main thread finish." );
		
	}

}
