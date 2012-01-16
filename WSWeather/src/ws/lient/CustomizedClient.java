package ws.lient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CustomizedClient {
	void testPost(String urlStr) {
		try {
			URL url = new URL(urlStr);
			URLConnection con = url.openConnection();
			con.setDoOutput(true);
			con.setRequestProperty("Pragma:", "no-cache");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Content-Type", "text/xml");

			OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
			String xmlInfo = getXmlInfo();
			out.write(new String(xmlInfo));
			out.flush();
			out.close();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = "";
			StringBuffer buf = new StringBuffer();
			for (line = br.readLine(); line != null; line = br.readLine()) {
				buf.append(new String(line.getBytes(), "UTF-8"));
			}
			System.out.println(buf.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getXmlInfo() {
		// ͨ��wsdl�ļ����Բ鿴�ӿ�xml��ʽ���ݣ�������ýӿ�xml����
		String xml = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">"
				+ "<SOAP-ENV:Body>"
				+ "<m:getItemDetailSingle xmlns:m=\"http:xxxxxxxxxxxxxxxxxx/\">"
				+ "<itemMo>"
				+ "<category>��������</category>"
				+ "<city>�������Ӻӱ���</city>"
				+ "<flag>3</flag>"
				+ "<itemId>10</itemId>"
				+ "<itemIndex>22</itemIndex>"
				+ "<keyword>������</keyword>"
				+ "<mobile>139-0111-1111</mobile>"
				+ "<password>iteyePl</password>"
				+ "<userName>hwak</userName>"
				+ "</itemMo>" + "</m:getItemDetailSingle>" + "</SOAP-ENV:Body>" + "</SOAP-ENV:Envelope>";
		return xml;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String xmlInfo = new CustomizedClient().getXmlInfo();
//		System.out.println(xmlInfo);
		
		String url = "http://localhost:9999/dataService/services/Job";
		new CustomizedClient().testPost(url);
	}
}