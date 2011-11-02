package demo.rmi.server;

import java.rmi.Remote;   
import java.rmi.RemoteException;   
  
public interface RmiSample extends Remote {   
	
    public int sum(int a, int b) throws RemoteException;   
    
}   