package demo.spring3.aop;

import static org.junit.Assert.assertNotNull;

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
		User user = userService.getUserByUid(1L);
		assertNotNull(user);
	}
	
	@Test
	public void testupdaeUserByUid(){
		userService.updateUserByUid(1L);
	}
	
}
