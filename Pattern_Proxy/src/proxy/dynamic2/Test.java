package proxy.dynamic2;

public class Test {

	public static void main(String[] args) {

		IHello hello = (IHello) new DynaProxy().bind(new HelloImpl(), new OperationImpl());

		hello.sayHello("tom");

	}
}