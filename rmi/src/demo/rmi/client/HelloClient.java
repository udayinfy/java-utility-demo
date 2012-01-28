package demo.rmi.client;

import java.rmi.Naming;

import demo.rmi.server.HelloInterface;

public class HelloClient {
	/**
	 * ����Զ�̶��󲢵���Զ�̷���
	 */
	public static void main(String[] argv) {
		try {
			HelloInterface hello = (HelloInterface) Naming.lookup("//127.0.0.1:1098/Hello");

			// ���Ҫ����һ̨������RMIע�����Ļ����ϲ���helloʵ��
			// HelloInterface hello =
			// (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");

			// ����Զ�̷���
			System.out.println(hello.say("welcome."));
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}
}
