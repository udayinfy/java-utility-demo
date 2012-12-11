package demo.client;

public class HttpTest {

	public static void main(String[] args) {

		try {

			String postUrl = "http://localhost:8080/WebApp/PostServlet";
			HttpClient client = new HttpClient();
			client.setPostUrl(postUrl);
			String result = client.doPost("a=1&b=2");
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// try {
		//
		// String getUrl = "http://localhost:8080/webapp/test";
		// HttpClient client = new HttpClient();
		// client.setGetUrl(getUrl);
		// String result = client.doGet();
		// System.out.println(result);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

}
