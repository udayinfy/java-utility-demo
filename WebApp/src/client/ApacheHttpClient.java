package client;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.util.URIUtil;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class ApacheHttpClient {

	public void doGet() {
		
		String url = "";
		String queryString = "";
		String response = null;
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		
		try {
			if (StringUtils.hasText(queryString))
				method.setQueryString(URIUtil.encodeQuery(queryString));
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				response = method.getResponseBodyAsString();
			}
		} catch (URIException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}

		System.out.println(response);
		
	}

	@Test
	public void doPost() {
		
		String url = "http://localhost:8080/WebApp/PostServlet";

		String response = null;
		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod(url);

		NameValuePair paramA = new NameValuePair("ParamA", "ValueA");
		NameValuePair paramB = new NameValuePair("ParamB", "ValueB");
		NameValuePair[] paramArr = new NameValuePair[]{paramA, paramB};
		method.setQueryString(paramArr);

//		Map<String, String> params = new HashMap<String, String>();
//		params.put("ParamA", "ValueA");
//		params.put("ParamB", "ValueB");
//		
//		// 璁剧疆Http Post鏁版嵁
//		if (paramArr != null) {
//			HttpMethodParams httpParams = new HttpMethodParams();
//			for (Map.Entry<String, String> entry : params.entrySet()) {
//				httpParams.setParameter(entry.getKey(), entry.getValue());
//			}
//			method.setParams(httpParams);
//		}

		try {
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				response = method.getResponseBodyAsString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}

		System.out.println(response);
	}

}
