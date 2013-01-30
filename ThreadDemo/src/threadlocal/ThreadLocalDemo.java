package threadlocal;

import java.util.Random;

public class ThreadLocalDemo implements Runnable {
	// �����ֲ߳̾�����personLocal���ں�����ᷢ����������Student����
	private final static ThreadLocal<Person> personLocal = new ThreadLocal<Person>();

	public static void main(String[] agrs) {
		ThreadLocalDemo td = new ThreadLocalDemo();
		Thread t1 = new Thread(td, "a");
		Thread t2 = new Thread(td, "b");
		t1.start();
		t2.start();
	}

	public void run() {
		accessStudent();
	}

	/**
	 * ʾ��ҵ�񷽷�����������
	 */
	public void accessStudent() {
		// ��ȡ��ǰ�̵߳�����
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("thread "+ currentThreadName + " is running!");
		// ����һ�����������ӡ
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("thread " + currentThreadName + " set age to:" + age);
		// ��ȡһ��Student���󣬲��������������뵽����������
		Person person = getStudent();
		person.setAge(age);
		System.out.println("thread " + currentThreadName + " first read age is:" + person.getAge());
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("thread " + currentThreadName + " second read age is:" + person.getAge());
	}

	protected Person getStudent() {
		// ��ȡ�����̱߳�����ǿ��ת��ΪStudent����
		Person person = personLocal.get();
		// �߳��״�ִ�д˷�����ʱ��personLocal.get()�϶�Ϊnull
		if (person == null) {
			// ����һ��Student���󣬲����浽�����̱߳���personLocal��
			person = new Person();
			personLocal.set(person);
		}
		return person;
	}
}