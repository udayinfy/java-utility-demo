package webservice.axis.wsddchain;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;


/**
 * WebService的Handle类，可以在WebService每个方法被调用之前或者之后做一些事情。
 */
public class HelloWorldHandler2 extends BasicHandler {
	
	private static final long serialVersionUID = 772997192033702477L;
	
	private static long COUNT = 0L;
	private int requestCount = 0;

	public void invoke(MessageContext arg0) throws AxisFault {
		requestCount++;
		COUNT++;
		String status = (String) this.getOption("status");
		System.out.println("This is an other handler. HelloWorldHandler2's status is: " + status + ", COUNT=" + COUNT + ",HandlerRequestCount=" + requestCount);
	}
}