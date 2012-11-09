package demo.hessian.client;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

import demo.hessian.service.IHelloWorld;
import demo.hessian.service.User;

public class HelloWorldClient {

	public static void main(String[] args) throws MalformedURLException {
		
		String url = "http://127.0.0.1:8080/HessianDemo/helloworld";
		HessianProxyFactory factory = new HessianProxyFactory();
		IHelloWorld helloworld = (IHelloWorld) factory.create(IHelloWorld.class, url);

		User user = new User();
		user.setName("UserOne");
		user.setGender("Male");
		String helloString = helloworld.hello(user);
		System.out.println(helloString);
	}

}
