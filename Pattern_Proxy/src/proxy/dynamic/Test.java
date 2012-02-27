package proxy.dynamic;

public class Test {

	public static void main(String[] args) {

		IHello hello = (IHello) new DynaProxyHello().bind(new HelloImpl());

		hello.sayHello("tom");

	}
}