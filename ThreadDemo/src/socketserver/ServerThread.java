package socketserver;

//��ServerThread 
import java.io.*;
import java.net.*;


public class ServerThread extends Thread {
	Socket clientRequest;  // �û����ӵ�ͨ���׽���
	BufferedReader input;  // ������
	PrintWriter output;  // �����

	public ServerThread(Socket s) {  // serverThread�Ĺ�����
		this.clientRequest = s;  // ����receiveServer�������׽���
		InputStreamReader reader;
		OutputStreamWriter writer;
		try {  // ��ʼ�����롢�����
			reader = new InputStreamReader(clientRequest.getInputStream());
			writer = new OutputStreamWriter(clientRequest.getOutputStream());
			input = new BufferedReader(reader);
			output = new PrintWriter(writer, true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		output.println("Welcome to the server!");  // �ͻ������ӻ�ӭ��
		output.println("Now is: " + new java.util.Date() + " " + "Port:"
				+ clientRequest.getLocalPort());
		output.println("What can I do for you?");
	}

	public void run() { // �̵߳�ִ�з���
		String command = null; // �û�ָ��
		String str = null;
		boolean done = false;
		while (!done) {
			try {
				str = input.readLine(); // ���տͻ���ָ��
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			command = str.trim().toUpperCase();
			if (str == null || command.equals("QUIT")) { // ����quit������������
				done = true;
			} else if (command.equals("HELP")) {  // ����help��ѯ���������ɽ��ܵ�����
				output.println("query");
				output.println("quit");
				output.println("help");
			} else if (command.startsWith("QUERY")) { // ����query
				output.println("OK to query something!");
			}
			// else if ����.. //�ڴ˿ɼ��������������ָ��
			else if (!command.startsWith("HELP") && !command.startsWith("QUIT")
					&& !command.startsWith("QUERY")) {
				output.println("Command not Found! Please refer to the HELP!");
			}
		}// end of while
		try {
			clientRequest.close(); // �ر��׽���
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		command = null;
	}// end of run
}