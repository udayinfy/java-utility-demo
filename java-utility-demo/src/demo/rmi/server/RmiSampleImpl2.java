package demo.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiSampleImpl2 extends UnicastRemoteObject implements RmiSample2 {

	private static final long serialVersionUID = 2742977636753958461L;

	public RmiSampleImpl2() throws RemoteException {
		super();
	}

	public int subduction(int a, int b) throws RemoteException{
		return a - b;
	}

}