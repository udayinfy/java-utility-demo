package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxyHello implements InvocationHandler {

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
	public Object bind(Object delegate) {
		this.delegate = delegate;

		// System.out.println(this.delegate.getClass().getClassLoader());
		// System.out.println(this.delegate.getClass().getInterfaces());

		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
	}

	/**
	 * Ҫ����Ķ����е�ÿ�������ᱻ�˷�����ȥJVM����, Ҳ����˵,Ҫ����Ķ���ķ���ֻ��ͨ���˷������� �˷����Ƕ�̬��,�����ֶ����õ�
	 */
	@Override
	public Object invoke(Object arg0, Method method, Object[] args) throws Throwable {

		Object result = null;
		try {
			// ִ��ԭ���ķ���֮ǰ��¼��־
			Logger.logging(Level.DEBUGE, method.getName() + " Method Start.");

			// JVMͨ���������ִ��ԭ���ķ���(�������)
			result = method.invoke(this.delegate, args);

			// ִ��ԭ���ķ���֮���¼��־
			Logger.logging(Level.INFO, method.getName() + " Method end!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ���ط�������ֵ��������
		return result;

	}

}

// ���������ַ��ֻ���һ������,���DynaPoxyHello����ֻ�ܸ�����
// ȥ�ڷ���ǰ�������־��¼�Ĳ���.
// �����ܲ��ܰ�DynaPoxyHello�������־��������(Logger)��ź��
