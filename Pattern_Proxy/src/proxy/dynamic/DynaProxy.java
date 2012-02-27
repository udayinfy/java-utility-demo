package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxy implements InvocationHandler {

	/**
	 * Ҫ����Ķ���,Ҳ��������Ҫ�ڷ�����ǰ�����ҵ���߼��Ķ���,�������е�Hello
	 */
	private Object delegate;

	/**
	 * ��̬���ɷ������������Ķ��� (д���̶�)
	 * @param delegate
	 * @return
	 */
	public Object bind(Object delegate) {
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
	}

	/**
	 * Ҫ����Ķ����е�ÿ�������ᱻ�˷�����ȥJVM����, Ҳ����˵,Ҫ����Ķ���ķ���ֻ��ͨ���˷�������, �˷����Ƕ�̬��,�����ֶ����õ�
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object result = null;
		try {
			// ִ��ԭ���ķ���֮ǰ��¼��־
			System.out.println("start ............ ");

			// JVMͨ���������ִ��ԭ���ķ���(�������)
			result = method.invoke(this.delegate, args);

			// ִ��ԭ���ķ���֮���¼��־
			System.out.println("end ............ ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ���ط�������ֵ��������
		return result;

	}

}

/*
 * ���������ַ��ֻ���һ������,���DynaPoxyHello����ֻ�ܸ����� ȥ�ڷ���ǰ�������־��¼�Ĳ���.
 * �����ܲ��ܰ�DynaPoxyHello�������־��������(Logger)��ź��
 */


