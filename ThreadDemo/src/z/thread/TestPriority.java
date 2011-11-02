package z.thread;

public class TestPriority {
	
	public static void main(String[] args) {
		Thread4 t1 = new Thread4("t1");
		Thread5 t2 = new Thread5("t2");
		// �������ȼ����õ������CPUִ��ʱ��
		t1.setPriority( Thread.MAX_PRIORITY );
		t1.start();
		t2.start();
	}

}

class Thread4 extends Thread {

	public Thread4(String name) {
		super(name);
	}

	@Override
	public void run() {
		super.run();
		for( int i=0; i<1000; i++ ){
			System.out.println( this.getName() + " " + i );
		}
	}
	
}

class Thread5 extends Thread {

	public Thread5(String name) {
		super(name);
	}

	@Override
	public void run() {
		super.run();
		for( int i=0; i<1000; i++ ){
			System.out.println( this.getName() + " " + i );
		}
	}
	
}
