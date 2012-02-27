package proxy.simple;

public class Hello implements IHello {
	
	@Override
	public void sayHello(String name) {
		
		System.out.println("Hello " + name + ".");
		
	}

}
