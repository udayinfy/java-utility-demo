package z.pandc;

public class ProducerConsumer {

	public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		
		new Thread(p).start();
		new Thread(c).start();
		
	}
	
}

class Producer implements Runnable{
	SyncStack ss = null;
	public Producer(SyncStack ss) {
		super();
		this.ss = ss;
	}

	@Override
	public void run() {
		for( int i=0; i<20; i++ ){
			Product pro = new Product(i);
			ss.push(pro);
			System.out.println("生产了：" + pro);
			
			try {
				Thread.sleep( (int)(Math.random() * 200) );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer implements Runnable{
	SyncStack ss = null;
	public Consumer(SyncStack ss) {
		super();
		this.ss = ss;
	}
	@Override
	public void run() {
		for( int i=0; i<20; i++ ){
			Product pro = ss.pop();
			System.out.println( "消费了：" + pro);
			try {
				Thread.sleep( (int)(Math.random() * 1000) );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Product{
	public int id;
	Product(int id){
		this.id = id;
	}
	public String toString(){
		return "Product " + id;
	}
}

class SyncStack{
	int index = 0;
	Product[] arrPro = new Product[6];
	
	public synchronized void push( Product pro ){
//		if( index==arrPro.length ){
		while( index==arrPro.length ){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		arrPro[index] = pro;
		index++;
	}
	
	public synchronized Product pop(){
//		if( index==0 ){
		while( index==0 ){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return arrPro[index];
	}
}

