package demo.rmi.client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import demo.rmi.server.RmiSample;
import demo.rmi.server.RmiSample2;


public class RmiSampleClient {

	public static void main(String[] args) {
		
		try {

			String url = "//localhost:8808/SAMPLE-SERVER-1";

			RmiSample rmiObject = (RmiSample) Naming.lookup(url);
			int a = rmiObject.sum(1, 2);
			System.out.println("1 + 2 = " + a);
			
			String url2 = "//localhost:8808/SAMPLE-SERVER-2";
			RmiSample2 rmiObject2 = (RmiSample2) Naming.lookup(url2);
			int b = rmiObject2.subduction(3, 2);
			System.out.println("3 - 2 = " + b);

		} catch (RemoteException rex) {
			System.out.println("Error in lookup: " + rex.toString());
		} catch (java.net.MalformedURLException me) {
			System.out.println("Malformed URL: " + me.toString());
		} catch (java.rmi.NotBoundException ne) {
			System.out.println("NotBound: " + ne.toString());
		}

	}

}