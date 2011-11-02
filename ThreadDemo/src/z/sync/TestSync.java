package z.sync;

public class TestSync implements Runnable {

	Bank bank = new Bank();
	
	public static void main(String[] args){
		TestSync r = new TestSync();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
	
	
	@Override
	public void run() {
		bank.add();
	}

}

class Bank { 
	
	private int count = 0;
	
	public synchronized void add(){
		count++;
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(" 你是第" + count + "个使用Bank的线程。");
	}
	
	
}
