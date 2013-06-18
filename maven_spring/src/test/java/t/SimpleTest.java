package t;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class SimpleTest {

	@Test
	public void simpleTest() {

		// ����mock���󣬲����������࣬Ҳ�����ǽӿ�
		List<String> list = mock(List.class);

		// ���÷�����Ԥ�ڷ���ֵ
		when(list.get(0)).thenReturn("helloworld");

		String result = list.get(0);

		// ��֤��������(�Ƿ������get(0))
		verify(list).get(0);

		// junit����
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