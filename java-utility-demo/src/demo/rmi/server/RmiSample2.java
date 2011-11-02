package demo.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiSample2 extends Remote {

	public int subduction(int a, int b) throws RemoteException;

}