package demo.cglib;

import net.sf.cglib.proxy.Enhancer;

public class TestCglibProxy {

	public static void main(String rags[]) {
		Target target = new Target();
		TestCglibProxy test = new TestCglibProxy();
		Target proxyTarget = (Target) test.createProxy(Target.class);
		String res = proxyTarget.execute();
		System.out.println(res);
	}

	public Object createProxy(Class targetClass) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClass);
		enhancer.setCallback(new MyMethodInterceptor());
		return enhancer.create();
	}
}