package proxy.dynamic;

public class Test {
	
	public static void main(String[] args) {
		
		IHello hello = (IHello) new DynaProxyHello().bind(new Hello());
		
		hello.sayHello("tom");

	}
}