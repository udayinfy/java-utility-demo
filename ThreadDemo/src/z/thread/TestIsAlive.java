package z.thread;

public class TestIsAlive {
	
	public static void main(String[] args) {
		Thread6 t = new Thread6("t1");
		t.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t.isAlive());
		
	}

}

class Thread6 extends Thread {

	public Thread6(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		super.run();
		System.out.println( Thread.currentThread().isAlive() );
		for( int i=0; i<10; i++ ){
			System.out.println( this.getName() + " " + i );
		}
	}
	
}


