package demo.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiSampleServer {

	public static void main(String[] args) {
		
		try {
			
			LocateRegistry.createRegistry(8808);
			
			RmiSample service1 = new RmiSampleImpl();
			
			try {
				Naming.bind("//localhost:8808/SAMPLE-SERVER-1", service1);
			} catch (AlreadyBoundException e) {
				e.printStackTrace();
			}
			
			RmiSample2 service2 = new RmiSampleImpl2();
			
			try {
				Naming.bind("//localhost:8808/SAMPLE-SERVER-2", service2);
			} catch (AlreadyBoundException e) {
				e.printStackTrace();
			}
			
			System.out.println("RMI Server Has Started....");
			
		} catch (MalformedURLException me) {
			System.out.println("Malformed URL: " + me.toString());
		} catch (RemoteException re) {
			System.out.println("Remote Exception: " + re.toString());
		}
	}
}