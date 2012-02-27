package proxy.dynamic;

public class Test {

	public static void main(String[] args) {

		IHello hello = (IHello) new DynaProxy().bind(new HelloImpl());

		hello.sayHello("tom");

	}
}