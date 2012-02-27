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
 * 但是我们会发现一个问题,如果我们像Hello这样的类很多,那么我们就要要去写
 * 很多个HelloProxy这样的类,是一种很麻烦的事.在jdk1.3以后jdk跟我们提供了 一个API,
 * java.lang.reflect.InvocationHandler类. 这个类 可以让我们在JVM调用某个类的方法时动态的为此方法做些什么
 */