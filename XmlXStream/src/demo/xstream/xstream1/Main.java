package demo.xstream.xstream1;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Main {

	@Test
	public void test() {

		// write
//		Birthday birthday = new Birthday("2008", "08", "08");
//		Person person = new Person("赵", null, null, birthday);
//		write(person);

		// read
		String fileUrl = System.getProperty("user.dir") + "\\src\\demo\\xstream\\xstream1\\" + "Person.xml";
		String xmlPerson = FileUtil.readToBuffer(fileUrl);
		read(xmlPerson);

	}

	public void write(Person person) {
		XStream xStream = new XStream();
		try {

			configAlias(xStream);

			String xmlPerson = xStream.toXML(person);
			System.out.println(xmlPerson);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public void read(String xmlPerson) {
		XStream xStream = new XStream(new DomDriver());
		try {

			configAlias(xStream);

			Person t = (Person) xStream.fromXML(xmlPerson);
			System.out.println(t.getSal());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public void configAlias(XStream xStream) {

		xStream.aliasType("Person", Person.class);

		xStream.aliasAttribute(Person.class, "gender", "gender1");
		xStream.aliasAttribute(Person.class, "name", "name1");
		xStream.useAttributeFor(Person.class);

		xStream.aliasAttribute(Birthday.class, "year", "year1");
		xStream.useAttributeFor(Birthday.class);
	}

}
