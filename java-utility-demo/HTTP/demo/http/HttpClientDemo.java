package demo.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientDemo {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		HttpResponse httpResponse = httpClient.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		
		if (entity != null) {
			InputStream inStream = entity.getContent();
			InputStreamReader inStreamReader = new InputStreamReader(inStream);
			BufferedReader bufferedReader = new BufferedReader(inStreamReader);
			String temp = "";
			while( (temp = bufferedReader.readLine()) != null ){
				System.out.println(temp);
			}
		}

	}

}
