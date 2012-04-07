package dynamicproxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import dynamicproxy.service.impl.PersonServiceBean;

public class JDKProxyFactory implements InvocationHandler{
	private Object targetObject;
	
	public Object createProxyIntance(Object targetObject){
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(), 
				this.targetObject.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {//环绕通知
		PersonServiceBean bean = (PersonServiceBean) this.targetObject;
		Object result = null; 
		if(bean.getUser()!=null){
			//..... advice()-->前置通知
			try {
				result = method.invoke(targetObject, args);
				// afteradvice() -->后置通知
			} catch (RuntimeException e) {
				//exceptionadvice()--> 例外通知
			}finally{
				//finallyadvice(); -->最终通知
			}
		}
		return result;
	}

}
