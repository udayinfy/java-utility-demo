package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxy implements InvocationHandler {

	/**
	 * 要处理的对象,也就是我们要在方法的前后加上业务逻辑的对象,如例子中的Hello
	 */
	private Object delegate;

	/**
	 * 动态生成方法被处理过后的对象 (写法固定)
	 * @param delegate
	 * @return
	 */
	public Object bind(Object delegate) {
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
	}

	/**
	 * 要处理的对象中的每个方法会被此方法送去JVM调用, 也就是说,要处理的对象的方法只能通过此方法调用, 此方法是动态的,不是手动调用的
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object result = null;
		try {
			// 执行原来的方法之前记录日志
			System.out.println("start ............ ");

			// JVM通过这条语句执行原来的方法(反射机制)
			result = method.invoke(this.delegate, args);

			// 执行原来的方法之后记录日志
			System.out.println("end ............ ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 返回方法返回值给调用者
		return result;

	}

}

/*
 * 但是我们又发现还有一个问题,这个DynaPoxyHello对象只能跟我们 去在方法前后加上日志记录的操作.
 * 我们能不能把DynaPoxyHello对象和日志操作对象(Logger)解藕呢
 */


