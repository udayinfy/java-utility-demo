package test;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import localhost.axis1.services.HelloWorldWSDD.HelloWorldWSDD;
import localhost.axis1.services.HelloWorldWSDD.HelloWorldWSDDService;
import localhost.axis1.services.HelloWorldWSDD.HelloWorldWSDDServiceLocator;

public class WSTest {

	public static void main(String[] args) {
		
		try {
			
			HelloWorldWSDDService service = new HelloWorldWSDDServiceLocator();
			
			HelloWorldWSDD helloService = service.getHelloWorldWSDD();
			
			Float add = helloService.add(3f, 4f);
			System.out.println(add);
			
			String hello = helloService.hello("ws");
			System.out.println(hello);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
