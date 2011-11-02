package z.sync;

public class TestDeadLock implements Runnable {
	public int flag;
	public static Object o1 = new Object();
	public static Object o2 = new Object();

	public void run() {
		if (flag == 0) {
			synchronized (o1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println(0);
				}
			}
		}
		if (flag == 1) {
			synchronized (o2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println(1);
				}
			}

		}
	}

	public static void main(String[] args) {
		System.out.println("Dead Lock.");
		TestDeadLock r1 = new TestDeadLock();
		TestDeadLock r2 = new TestDeadLock();
		r1.flag = 0;
		r2.flag = 1;
		new Thread(r1).start();
		new Thread(r2).start();
	}
}
