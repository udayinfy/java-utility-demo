package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			
			socket = new Socket("localhost", 1234);
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			String filePath = System.getProperty("user.dir") + "/http-soap.txt";
			
			String buffer = FileUtil.readToBuffer(filePath, "utf-8");
			
			dos.writeUTF(buffer);
			
			System.out.println(dis.readUTF());
			
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
