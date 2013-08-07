package demo.spring3.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { 
		"classpath:demo/spring3/aop/spring-aop.xml"
		}) 
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringAop {
	
	@Autowired
	UserService userService;
	
	@Test
	public void testgetUserByUId(){
		String uid = "auid";
		userService.getUserByUid(uid);
	}
	
	@Test
	public void testupdaeUserByUid(){
		String uid = "auid";
		userService.updateUserByUid(uid);
	}
	
}
