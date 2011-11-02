package z.thread;

public class TestJoin {
	
	public static void main( String[] args ){
		Thread2 t = new Thread2("thread2");
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for( int i=0; i<10; i++ ){
			System.out.println("I am main thread." );
		}
		
	}
	

}

class Thread2 extends Thread {
	
	public Thread2(String name) {
		super(name);
	}

	@Override
	public void run() {
		super.run();
		for( int i=0; i<10; i++ ){
			System.out.println("I am " + this.getName() + ".");
		}
	}
	
}