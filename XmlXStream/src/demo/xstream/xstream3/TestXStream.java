package demo.xstream.xstream3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class TestXStream {

	@Test
	public void test() {
		testXSteam();
	}

	public void testXSteam() {
		System.out.println("----------XStream学习----------");
		
		// 目标对象
		Province province1 = new Province("河北", "大省份");
		City city1 = new City("保定", "大城市");
		Address address1 = new Address(province1, city1);
		
		Province province2 = new Province("辽宁", "大省份");
		City city2 = new City("大连", "大城市");
		Address address2 = new Address(province2, city2);
		
		List<Address> addList = new ArrayList<Address>();
		addList.add(address1);
		addList.add(address2);
		
		Profile profile = new Profile("软件工程师", "13688889999", "备注说明");
		Person person = new Person("赵钱孙", "27", profile, addList);
		// 转换装配
		XStream xStream = new XStream();

		output(1, xStream, person);
		
		
		/************* 将xml转为java对象 ************/
		String fileUrl = System.getProperty("user.dir") + File.separator + "xstream3" 
								+ File.separator + "Person.xml";
		String person_xml = FileUtil.readToBuffer(fileUrl);
	
		// 同样实用上面的XStream对象xStream
		System.out.println(">>>第[2]次输出");
		System.out.println(xStream.fromXML(person_xml).toString() + "\n");

	}

	public static void output(int i, XStream xStream, Object obj) {
		String xml = xStream.toXML(obj);
		System.out.println(">>>第[" + i + "]次输出");
		System.out.println(xml + "\n");
	}
}