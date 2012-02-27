package proxy.dynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxy implements InvocationHandler {

	/**
	 * ������
	 */
	private Object proxy;

	/**
	 * Ҫ����Ķ���,Ҳ��������Ҫ�ڷ�����ǰ�����ҵ���߼��Ķ���,�������е�Hello
	 */
	private Object delegate;

	/**
	 * ��̬���ɷ������������Ķ��� (д���̶�)
	 * 
	 * @param delegate
	 * @param proxy
	 * @return
	 */
	public Object bind(Object delegate, Object proxy) {
		this.proxy = proxy;
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
	}

	/**
	 * Ҫ����Ķ����е�ÿ�������ᱻ�˷�����ȥJVM����, Ҳ����˵,Ҫ����Ķ���ķ���ֻ��ͨ���˷������� �˷����Ƕ�̬��,�����ֶ����õ�
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			// ����õ������ߵ�ʵ��
			Class clazz = this.proxy.getClass();

			// ����õ������ߵ�Start����
			Method startMethod = clazz.getDeclaredMethod("start", new Class[] { Method.class });

			// ����ִ��start����
			startMethod.invoke(this.proxy, new Object[] { method });

			// ִ��Ҫ��������ԭ������
			result = method.invoke(this.delegate, args);

			// ����õ������ߵ�end����
			Method endMethod = clazz.getDeclaredMethod("end", new Class[] { Method.class });

			// ����ִ��end����
			endMethod.invoke(this.proxy, new Object[] { method });

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

/*
 * ������ǲ��������з���������־��¼,����Ӧ����ôȥ��ź��. �ҵ��뷨���ڴ������� public Object invoke(Object proxy,
 * Method method, Object[] args)����������ϸ�if(),�Դ�������
 * method�����ֽ����ж�,�жϵ���������XML����.�������ǾͿ����� ���ļ�ʱ�н�ź��.������,��������,��ͨ��,
 * ��ô�Ϳ���дһ���򵥵�SpringAOP�����.
 */

