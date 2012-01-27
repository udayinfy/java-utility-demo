package demo.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 对象的序列化和反序列化测试类
 * 2010/12/3 14:15
 */
public class ObjectSaver {

	public static void main(String[] args) throws Exception {

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				System.getProperty("user.dir") + "\\objectFile.obj"));

		// 序列化对象
		Customer customer = new Customer("阿蜜果", 24);
		out.writeObject("你好!");
		out.writeObject(new Date());
		out.writeObject(customer);
		// 写入基本类型数据
		out.writeInt(123);

		out.close();

		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				System.getProperty("user.dir") + "\\objectFile.obj"));
		
		// 反序列化对象
		System.out.println("obj1=" + (String) in.readObject());
		System.out.println("obj2=" + (Date) in.readObject());
		Customer obj3 = (Customer) in.readObject();
		System.out.println("obj3=" + obj3);
		int obj4 = in.readInt();
		System.out.println("obj4=" + obj4);

		in.close();

	}

}

class Customer implements Serializable {
	
/*	凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量：
	private static final long serialVersionUID;
	以上serialVersionUID的取值是Java运行时环境根据类的内部细节自动生成的。如果对类的源代码作了修改，再重新编译，
	新生成的类文件的serialVersionUID的取值有可能也会发生变化。
	类的serialVersionUID的默认值完全依赖于Java编译器的实现，对于同一个类，用不同的Java编译器编译，有可能会导致
	不同的serialVersionUID，也有可能相同。为了提高serialVersionUID的独立性和确定性，强烈建议在一个可序列化
	类中显示的定义serialVersionUID，为它赋予明确的值。显式地定义serialVersionUID有两种用途：
	1） 在某些场合，希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有相同的serialVersionUID；
	2）在某些场合，不希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有不同的serialVersionUID。
*/
	private static final long serialVersionUID = -3584609121392685999L;
	
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "name=" + name + ", age=" + age;
	}

}
