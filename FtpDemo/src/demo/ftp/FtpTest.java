package demo.ftp;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class FtpTest {
	
	public static void main(String[] args) {
		testUpload();
		// testDownload();
	}

	/**
	 * FTP�ϴ������ļ�����
	 */
	public static void testUpload() {
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;

		try {
			ftpClient.connect("127.0.0.1");
			ftpClient.login("root", "123456");

			File srcFile = new File("D:\\temp.txt");
			fis = new FileInputStream(srcFile);
			// �����ϴ�Ŀ¼
			ftpClient.changeWorkingDirectory("/");
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("GBK");
			// �����ļ����ͣ������ƣ�
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.storeFile("temp.txt", fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("FTP�ͻ��˳���", e);
		} finally {
			IOUtils.closeQuietly(fis);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�FTP���ӷ����쳣��", e);
			}
		}
	}

	/**
	 * FTP���ص����ļ�����
	 */
	public static void testDownload() {
		FTPClient ftpClient = new FTPClient();
		FileOutputStream fos = null;

		try {
			ftpClient.connect("127.0.0.1");
			ftpClient.login("root", "123456");

			String remoteFileName = "/admin/pic/3.gif";
			fos = new FileOutputStream("c:/down.gif");

			ftpClient.setBufferSize(1024);
			// �����ļ����ͣ������ƣ�
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.retrieveFile(remoteFileName, fos);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("FTP�ͻ��˳���", e);
		} finally {
			IOUtils.closeQuietly(fos);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�FTP���ӷ����쳣��", e);
			}
		}
	}
}