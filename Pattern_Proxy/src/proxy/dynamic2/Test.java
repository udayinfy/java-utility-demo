package proxy.dynamic2;

public class Test {

	public static void main(String[] args) {

		IHello hello = (IHello) new DynaProxyHello().bind(new HelloImpl(), new OperationImpl());

		hello.sayHello("tom");

	}
}