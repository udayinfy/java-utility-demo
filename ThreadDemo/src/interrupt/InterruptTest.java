package interrupt;

/**
 * ������һ���߳������жϵķ������������ñ�־λ���⣬
 * ��Ҫ�����̶߳����interrupt����
 * @author Admin
 *
 */
public class InterruptTest implements Runnable{

	public volatile static boolean flag = true;
	
	@Override
	public void run() {
		while( flag ){
			System.out.println( "sub thread is running." );
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println( "error message: " + e.getMessage() );
			}
		}
		System.out.println( "sub thread finished." );
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Runnable r = new InterruptTest();
		Thread t = new Thread(r);
		
		t.start();
		
		// �����̹߳���1����
		Thread.sleep(1000);
		
		InterruptTest.flag = false;
		t.interrupt();
		
		System.out.println( "main thread finished." );
		
	}
	

}
