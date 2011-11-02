package synchronize;

/**
 * ����ڷǾ�̬����method1��method2����ʱ��ʹ����synchronized��
 * ��method1δִ����֮ǰ��method2�ǲ���ִ�еġ�
 * ��̬�����ͷǾ�̬������������ơ�����̬�ͷǾ�̬�������ụ��Ӱ�졣
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
		method("�Ǿ�̬��method1����");
	}

	public synchronized void method2() {
		method("�Ǿ�̬��method2����");
	}

	public static synchronized void method3() {
		method("��̬��method3����");
	}

	public static synchronized void method4() {
		method("��̬��method4����");
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