package demo.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println(">>>MethodInterceptor start...");
		Object result = methodProxy.invokeSuper(object, args);
		System.out.println(">>>MethodInterceptor ending...");
		return "the return value";
	}
}