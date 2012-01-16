package ws.client.weather;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;

import cn.com.WebXml.WeatherWebService;
import cn.com.WebXml.WeatherWebServiceLocator;
import cn.com.WebXml.WeatherWebServiceSoap;
import cn.com.WebXml.WeatherWebServiceSoapStub;

public class WeatherServiceTest {

	public static void main(String[] args) {
		
		try {
			
			WeatherWebService weService = new WeatherWebServiceLocator();
			
			WeatherWebServiceSoap webServiceSoap = weService.getWeatherWebServiceSoap();
			
			String[] supportProvince = webServiceSoap.getSupportProvince();
			
			System.out.println(Arrays.toString(supportProvince));
			
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

}
