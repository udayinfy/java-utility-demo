package proxy.simple;

public class ProxyHello implements IHello {

	private IHello hello;

	public ProxyHello(IHello hello) {
		this.hello = hello;
	}

	@Override
	public void sayHello(String name) {

		System.out.println("start ............ ");

		hello.sayHello(name);

		System.out.println("end ............ ");

	}

}

/*
 * �������ǻᷢ��һ������,���������Hello��������ܶ�,��ô���Ǿ�ҪҪȥд
 * �ܶ��HelloProxy��������,��һ�ֺ��鷳����.��jdk1.3�Ժ�jdk�������ṩ�� һ��API,
 * java.lang.reflect.InvocationHandler��. ����� ������������JVM����ĳ����ķ���ʱ��̬��Ϊ�˷�����Щʲô
 */