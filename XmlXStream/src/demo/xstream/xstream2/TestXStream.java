package demo.xstream.xstream2;

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
		Address address1 = new Address("北京海淀", "100000");
		Address address2 = new Address("北京东城", "100000");
		List<Address> addList = new ArrayList<Address>();
		addList.add(address1);
		addList.add(address2);
		Profile profile = new Profile("软件工程师", "13688889999", "备注说明");
		Person person = new Person("赵钱孙", "27", profile, addList);
		// 转换装配
		XStream xStream = new XStream();
		
		/************** 设置类别名 ****************/
		xStream.alias("person", Person.class);
		xStream.alias("profile", Profile.class);
		xStream.alias("address", Address.class);
		output(1, xStream, person);
		
		/************* 设置类成员的别名 ***************/
		// 设置Person类的name成员别名Name
		xStream.aliasField("name", Person.class, "name");
		/*
		 * [注意] 设置Person类的profile成员别名PROFILE,这个别名和Profile类的别名一致,
		 * 这样可以保持XStream对象可以从profile成员生成的xml片段直接转换为Profile成员,
		 * 如果成员profile的别名和Profile的别名不一致,则profile成员生成的xml片段不可
		 * 直接转换为Profile对象,需要重新创建XStream对象,这岂不给自己找麻烦?
		 */
		xStream.aliasField("profile", Person.class, "profile");
		xStream.aliasField("addList", Person.class, "addList");
		xStream.aliasField("add", Address.class, "add");
		xStream.aliasField("job", Profile.class, "job");
		output(2, xStream, person);
		
		/******* 设置类成员为xml一个元素上的属性 *******/
		xStream.useAttributeFor(Address.class, "zipcode");
		
		/************* 设置属性的别名 ***************/
		xStream.aliasAttribute(Address.class, "zipcode", "zipcode");
		output(3, xStream, person);
		
		/************* 将xml转为java对象 ******× ****/
		String fileUrl = System.getProperty("user.dir") + File.separator + "xstream2" 
								+ File.separator + "Person.xml";
		String person_xml = FileUtil.readToBuffer(fileUrl);
		
		fileUrl = System.getProperty("user.dir") + File.separator + "xstream2" 
								+ File.separator + "Profile.xml";
		String profile_xml = FileUtil.readToBuffer(fileUrl);
		
		fileUrl = System.getProperty("user.dir") + File.separator + "xstream2" 
								+ File.separator + "Address.xml";
		String address_xml = FileUtil.readToBuffer(fileUrl);
		
		// 同样实用上面的XStream对象xStream
		System.out.println(">>>第[4]次输出");
		System.out.println(xStream.fromXML(person_xml).toString() + "\n");
		System.out.println(">>>第[5]次输出");
		System.out.println(xStream.fromXML(profile_xml).toString() + "\n");
		System.out.println(">>>第[6]次输出");
		System.out.println(xStream.fromXML(address_xml).toString() + "\n");
	}

	public static void output(int i, XStream xStream, Object obj) {
		String xml = xStream.toXML(obj);
		System.out.println(">>>第[" + i + "]次输出");
		System.out.println(xml + "\n");
	}
}