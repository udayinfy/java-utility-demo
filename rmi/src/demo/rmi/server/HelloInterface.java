package demo.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Զ�̽ӿڱ�����չ�ӿ�java.rmi.Remote
 */
public interface HelloInterface extends Remote {

	/**
	 * Զ�̽ӿڷ��������׳� java.rmi.RemoteException
	 */
	public String say(String content) throws RemoteException;

}