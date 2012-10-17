package junit.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuartzTest {
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("Spring-Quartz.xml");
	}

	@Test
	public void test(){
		new ClassPathXmlApplicationContext("Spring-Quartz.xml");
	}
	
}
