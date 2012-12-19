package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class JdkHttpClient {

	private String getUrl = null;
	private String postUrl = null;

	@Test
	public String doGet() throws IOException {

		URL url = new URL(getUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();

		InputStream inputStream = connection.getInputStream();

		int size = 0;

		byte[] buf = new byte[1];
		while (inputStream.read(buf) != -1) {
			size++;
		}
		inputStream.close();

		connection.disconnect();
		
		String retValue = new String(buf);
		
		return retValue;
	}

	@Test
	public String doPost() throws IOException {

		String content = "";
		URL url = new URL(postUrl);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setConnectTimeout(30000);
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");

		connection.connect();

		// write
		OutputStream outputStream = connection.getOutputStream();
		DataOutputStream out = new DataOutputStream(outputStream);
		content = java.net.URLEncoder.encode(content, "utf-8");
		out.writeBytes(content);
		out.flush();
		out.close();

		// read
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();
		connection.disconnect();

		return buffer.toString();
	}

	public String getGetUrl() {
		return getUrl;
	}

	public void setGetUrl(String getUrl) {
		this.getUrl = getUrl;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

}
