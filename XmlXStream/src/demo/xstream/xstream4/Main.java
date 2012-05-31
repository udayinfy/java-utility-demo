package demo.xstream.xstream4;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class Main {

	@Test
	public void test() {
		
		Address add = new Address();
		add.setValue("北京");
		add.setZipcode("100000");
		
		Address add2 = new Address();
		add2.setValue("上海");
		add2.setZipcode("200000");
		
		List<Address> unit = new ArrayList<Address>();
		unit.add(add);
		unit.add(add2);
		
//		Address add = new Address();
//		add.setValue("北京");
//		add.setZipcode("100000");

		Hi hi = new Hi();
		hi.setUnit( unit );
		
		write( hi );
	}

	public void write( Hi hi ) {
		XStream xStream = new XStream();
		try {
			
			configAlias( xStream );
			
			String xmlHi = xStream.toXML( hi );
			System.out.println( xmlHi );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	private void configAlias(XStream xStream) {
		
		xStream.alias("hi", Hi.class);
		xStream.alias("unit", Address.class);
		xStream.alias("address", Address.class);
		
		AttributeValueConveter converter = new AttributeValueConveter(xStream.getMapper());    
		converter.addConvertClass(Address.class);    
		xStream.registerConverter(converter);  
		xStream.registerConverter(new AttributeValueConveter(xStream.getMapper()));  
		
	}

	
	

}
