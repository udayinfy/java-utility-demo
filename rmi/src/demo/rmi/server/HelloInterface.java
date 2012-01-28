package demo.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程接口必须扩展接口java.rmi.Remote
 */
public interface HelloInterface extends Remote {

	/**
	 * 远程接口方法必须抛出 java.rmi.RemoteException
	 */
	public String say(String content) throws RemoteException;

}