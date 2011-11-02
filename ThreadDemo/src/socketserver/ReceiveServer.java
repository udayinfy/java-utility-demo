package socketserver;

import java.io.*;
import java.util.*;
import java.net.*;

public class ReceiveServer {

	final int RECEIVE_PORT = 9090; // �÷������Ķ˿ں�

	// receiveServer�Ĺ�����
	public ReceiveServer() {
		ServerSocket rServer = null;  // ServerSocket��ʵ��
		Socket request = null;  // �û�������׽���
		Thread receiveThread = null;
		try {
			rServer = new ServerSocket(RECEIVE_PORT);  // ��ʼ��ServerSocket
			System.out.println("Welcome to the server!");
			System.out.println(new Date());
			System.out.println("The server is ready!");
			System.out.println("Port: " + RECEIVE_PORT);

			while (true) { // �ȴ��û�����
				request = rServer.accept();  // ���տͻ�����������
				receiveThread = new ServerThread(request);  // ����serverThread��ʵ��
				receiveThread.start();  // ����serverThread�߳�
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) {
		new ReceiveServer();
	} // end of main
} // end of class 