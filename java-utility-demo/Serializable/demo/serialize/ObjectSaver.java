package demo.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * ��������л��ͷ����л�������
 * 2010/12/3 14:15
 */
public class ObjectSaver {

	public static void main(String[] args) throws Exception {

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				System.getProperty("user.dir") + "\\objectFile.obj"));

		// ���л�����
		Customer customer = new Customer("���۹�", 24);
		out.writeObject("���!");
		out.writeObject(new Date());
		out.writeObject(customer);
		// д����������
		out.writeInt(123);

		out.close();

		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				System.getProperty("user.dir") + "\\objectFile.obj"));
		
		// �����л�����
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
	
/*	����ʵ��Serializable�ӿڵ��඼��һ����ʾ���л��汾��ʶ��ľ�̬������
	private static final long serialVersionUID;
	����serialVersionUID��ȡֵ��Java����ʱ�����������ڲ�ϸ���Զ���ɵġ��������Դ���������޸ģ������±��룬
	����ɵ����ļ���serialVersionUID��ȡֵ�п���Ҳ�ᷢ��仯��
	���serialVersionUID��Ĭ��ֵ��ȫ������Java��������ʵ�֣�����ͬһ���࣬�ò�ͬ��Java���������룬�п��ܻᵼ��
	��ͬ��serialVersionUID��Ҳ�п�����ͬ��Ϊ�����serialVersionUID�Ķ����Ժ�ȷ���ԣ�ǿ�ҽ�����һ�������л�
	������ʾ�Ķ���serialVersionUID��Ϊ������ȷ��ֵ����ʽ�ض���serialVersionUID��������;��
	1�� ��ĳЩ���ϣ�ϣ����Ĳ�ͬ�汾�����л����ݣ������Ҫȷ����Ĳ�ͬ�汾������ͬ��serialVersionUID��
	2����ĳЩ���ϣ���ϣ����Ĳ�ͬ�汾�����л����ݣ������Ҫȷ����Ĳ�ͬ�汾���в�ͬ��serialVersionUID��
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
