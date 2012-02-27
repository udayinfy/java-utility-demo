package proxy.dynamic;

public class HelloImpl implements IHello {

	@Override
	public void sayHello(String name) {
		
		System.out.println("Hello " + name + ".");
		
	}

}
