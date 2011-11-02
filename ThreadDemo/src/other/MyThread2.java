package other;

public class MyThread2 {

	public static void main(String[] args) {
		House house = new House();
		Runnable1 r1 = new Runnable1(house);
		Runnable2 r2 = new Runnable2(house);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}

class House {

	public boolean isProxy = false;

	public synchronized void setProxy() {
		System.out.println("the house is proxing....");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("the house is proxied.");

		isProxy = true;
		notify();
	}

	public synchronized void rent() {

		while (!isProxy) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("the house is renting....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("the house is rented.");

	}

}

class Runnable1 implements Runnable {

	public House house = null;

	public Runnable1(House house) {
		this.house = house;
	}

	@Override
	public void run() {
		house.rent();
	}

}

class Runnable2 implements Runnable {

	public House house = null;

	public Runnable2(House house) {
		this.house = house;
	}

	@Override
	public void run() {
		house.setProxy();
	}

}
