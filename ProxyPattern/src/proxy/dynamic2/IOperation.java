package proxy.dynamic2;

import java.lang.reflect.Method;

public interface IOperation {

	/**
	 * ����ִ��֮ǰ�Ĳ���
	 * @param method
	 */
	public void start(Method method);

	/**
	 * ����ִ��֮��Ĳ���
	 * @param method
	 */
	public void end(Method method);

}
