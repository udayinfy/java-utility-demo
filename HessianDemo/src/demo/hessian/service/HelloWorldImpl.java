package demo.hessian.service;

public class HelloWorldImpl implements IHelloWorld {

	@Override
	public String hello(User user) {
		
		return "Hello World!" + user.getName() + "!";
	}

}
