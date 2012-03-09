package webservice.axis.client;

import java.rmi.RemoteException;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.JAFDataHandlerDeserializerFactory;
import org.apache.axis.encoding.ser.JAFDataHandlerSerializerFactory;

public class FileSenderClient {
	
	public static void main(String[] args) {
		
		try {
			String fileName = "/log4j.properties";
			DataHandler dh = new DataHandler(new FileDataSource(FileSenderClient.class.getResource(fileName).getPath()));
			String url = "http://127.0.0.1:8080/axis1/services/FileReceiverServer";
			Service serv = new Service();
			Call call = (Call) serv.createCall();
			call.setTargetEndpointAddress(url);
			call.setOperationName(new QName(url, "receive"));
			QName qn = new QName("DataHandler", "myNs:DataHandler");
			call.registerTypeMapping(DataHandler.class, qn, JAFDataHandlerSerializerFactory.class, JAFDataHandlerDeserializerFactory.class);
			call.addParameter("s1", qn, ParameterMode.IN);
			call.addParameter("s2", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnClass(String.class);
			String returnStr = (String) call.invoke(new Object[] { dh, "server.txt" });
			System.out.println("Server response: " + returnStr);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}