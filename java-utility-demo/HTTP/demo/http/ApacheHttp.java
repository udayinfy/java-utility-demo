package demo.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


public class ApacheHttp {
	
	@Test
	public void post() {

		String resp = "";
		HttpClient httpclient = new DefaultHttpClient();
		String postUrl = "http://localhost:8080/SpringMVC/hello.htm";
		
		
		HttpPost httppost = new HttpPost(postUrl);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("param", "paramValue"));

		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);

			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				resp = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		System.out.println(resp);
	}

}
