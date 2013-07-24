package demo.spring3.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { 
		"classpath:demo/**/Spring-Quartz.xml"
		}) 
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringQuartz {
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("demo/**/Spring-Quartz.xml");
	}
	
	@Test
	public void testrunQuartz(){
		
		System.out.println("test spring quartz");
		
		
		
	}
	
}
