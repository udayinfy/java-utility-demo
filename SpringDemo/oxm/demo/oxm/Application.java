package demo.oxm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;


public class Application {
	
	private static final String FILE_NAME = System.getProperty("user.dir") + "\\oxm\\demo\\oxm\\settings.xml";
	private Settings settings = new Settings();
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void saveSettings() throws IOException {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(FILE_NAME);
			this.marshaller.marshal(settings, new StreamResult(os));
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public void loadSettings() throws IOException {
		FileInputStream is = null;
		try {
			is = new FileInputStream(FILE_NAME);
			this.settings = (Settings) this.unmarshaller.unmarshal(new StreamSource(is));
			System.out.println(this.settings.isFooEnabled());
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/demo/oxm/applicationContext.xml");
		Application application = (Application) appContext.getBean("application");
		application.saveSettings();
		application.loadSettings();
	}
}