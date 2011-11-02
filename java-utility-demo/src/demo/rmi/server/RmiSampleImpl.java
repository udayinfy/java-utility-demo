package demo.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiSampleImpl extends UnicastRemoteObject implements RmiSample {
	
	private static final long serialVersionUID = 2742977636753958461L;

	public RmiSampleImpl() throws RemoteException {
		super();
	}

	public int sum(int a, int b) throws RemoteException {
		return a + b;
	}

}