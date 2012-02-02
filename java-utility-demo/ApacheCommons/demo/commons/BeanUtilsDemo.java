package demo.commons;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsDemo {
	
	public static void main(String[] args) {
		BeanObj1 beanobj1 = new BeanObj1();
		beanobj1.setId(110);
		beanobj1.setName("aname");
		beanobj1.setGender("male");
		beanobj1.setEmail("mail@mail.com");
		beanobj1.setTel("13655556666");
		
		BeanObj2 beanobj2 = new BeanObj2();
		try {
			BeanUtils.copyProperties(beanobj2, beanobj1);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(beanobj2);
	}

}
