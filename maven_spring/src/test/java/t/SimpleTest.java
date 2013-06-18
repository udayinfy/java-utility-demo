package t;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class SimpleTest {

	@Test
	public void simpleTest() {

		// 创建mock对象，参数可以是类，也可以是接口
		List<String> list = mock(List.class);

		// 设置方法的预期返回值
		when(list.get(0)).thenReturn("helloworld");

		String result = list.get(0);

		// 验证方法调用(是否调用了get(0))
		verify(list).get(0);

		// junit测试
		Assert.assertEquals("helloworld", result);
	}
	
	@Test  
	public void argumentMatcherTest(){   
	       
	    List<String> list = mock(List.class);   
	       
	    when(list.get(anyInt())).thenReturn("hello","world");   
	       
	    String result = list.get(0)+list.get(1);   
	       
	    verify(list,times(2)).get(anyInt());   
	       
	    Assert.assertEquals("helloworld", result);   
	       
	}  
}