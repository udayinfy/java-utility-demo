package z.thread;

public class TestYield {
	
	public static void main(String[] args) {
		Thread3 t1 = new Thread3("t1");
		Thread3 t2 = new Thread3("t2");
		t1.start();
		t2.start();
	}

}

class Thread3 extends Thread {

	public Thread3(String name) {
		super(name);
	}

	@Override
	public void run() {
		super.run();
		for( int i=0; i<100; i++ ){
			System.out.println( this.getName() + " " + i );
			if( i%10==0 )
				yield();
		}
	}
	
	
	
	
}
