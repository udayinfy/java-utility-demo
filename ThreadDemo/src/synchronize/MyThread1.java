package synchronize;

/**
 * 如果在非静态方法method1和method2定义时都使用了synchronized，
 * 在method1未执行完之前，method2是不能执行的。
 * 静态方法和非静态方法的情况类似。但静态和非静态方法不会互相影响。
 * 
 * @author Admin
 * 
 */
public class MyThread1 extends Thread {

	public String methodName;

	public static void method(String s) {
		System.out.println(s);
		while (true)
			;
	}

	public synchronized void method1() {
		method("非静态的method1方法");
	}

	public synchronized void method2() {
		method("非静态的method2方法");
	}

	public static synchronized void method3() {
		method("静态的method3方法");
	}

	public static synchronized void method4() {
		method("静态的method4方法");
	}

	public void run() {
		try {
			getClass().getMethod(methodName).invoke(this);
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) throws Exception {
		MyThread1 myThread1 = new MyThread1();
		for (int i = 1; i <= 4; i++) {
			myThread1.methodName = "method" + String.valueOf(i);
			new Thread(myThread1).start();
			sleep(100);
		}
	}
}