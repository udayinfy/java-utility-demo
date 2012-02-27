package proxy.simple;

public class Test {

	public static void main(String[] args) {

		IHello hello = new ProxyHello(new Hello());

		hello.sayHello("tom");

	}

}
