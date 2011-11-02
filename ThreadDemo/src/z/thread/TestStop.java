package z.thread;

public class TestStop {
	
	public static void main(String[] args) {
		Runner r = new Runner();
		Thread t = new Thread(r);
		t.start();
		
		for( int i=0; i<10000; i++ ){
			System.out.println( "main " + i );
		}
		
		// t.stop();
		r.shutdown();
		
	}

}

class Runner implements Runnable {

	public boolean flag = true;
	
	@Override
	public void run() {
		int i = 0; 
		while( flag ){
			System.out.println( i++ );
		}
	}
	
	public void shutdown(){
		this.flag = false;
	}
	
}