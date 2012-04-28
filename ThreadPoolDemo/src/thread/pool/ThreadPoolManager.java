package thread.pool;

//ThreadPoolManager.java 
import java.util.*;

class ThreadPoolManager {

	private int maxThread;
	public Vector<SimpleThread> vector;

	public void setMaxThread(int threadCount) {
		maxThread = threadCount;
	}

	public ThreadPoolManager(int threadCount) {
		setMaxThread(threadCount);
		System.out.println("Starting thread pool...");
		vector = new Vector<SimpleThread>();
		for (int i = 1; i <= 10; i++) {
			SimpleThread thread = new SimpleThread(i);
			vector.addElement(thread);
			thread.start();
		}
	}

	public void process(String argument) {
		int i;
		for (i = 0; i < vector.size(); i++) {
			SimpleThread currentThread = (SimpleThread) vector.elementAt(i);
			if (!currentThread.isRunning()) {
				System.out.println("Thread " + (i + 1) + " is processing:" + argument);
				currentThread.setArgument(argument);
				currentThread.setRunning(true);
				return;
			}
		}
		if (i == vector.size()) {
			System.out.println("pool is full, try in another time.");
		}
	}
}