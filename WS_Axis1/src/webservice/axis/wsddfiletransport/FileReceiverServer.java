package webservice.axis.wsddfiletransport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.activation.DataHandler;


public class FileReceiverServer {
	
	public String receive(DataHandler handler, String fileName) {
		
		File file = new File(fileName);
		if (handler == null || fileName == null || fileName.equals("")) {
			return "failure";
		}
		InputStream input = null;
		FileOutputStream fos = null;
		try {
			input = handler.getInputStream();
			fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			while (input.read(buffer) != -1) {
				fos.write(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "Success file saved on server. At: " + file.getAbsolutePath();
	}
}