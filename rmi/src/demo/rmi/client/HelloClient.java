package demo.rmi.client;

import java.rmi.Naming;

import demo.rmi.server.HelloInterface;

public class HelloClient {
	/**
	 * 查找远程对象并调用远程方法
	 */
	public static void main(String[] argv) {
		try {
			HelloInterface hello = (HelloInterface) Naming.lookup("//127.0.0.1:1098/Hello");

			// 如果要从另一台启动了RMI注册服务的机器上查找hello实例
			// HelloInterface hello =
			// (HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");

			// 调用远程方法
			System.out.println(hello.say("welcome."));
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}
}
