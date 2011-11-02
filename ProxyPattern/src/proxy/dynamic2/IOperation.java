package proxy.dynamic2;

import java.lang.reflect.Method;

public interface IOperation {

	/**
	 * 方法执行之前的操作
	 * @param method
	 */
	public void start(Method method);

	/**
	 * 方法执行之后的操作
	 * @param method
	 */
	public void end(Method method);

}
