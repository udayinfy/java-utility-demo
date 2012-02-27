package proxy.dynamic2;

import java.lang.reflect.Method;

public class OperationImpl {

	public void start(Method method) {
		System.out.println("start ............ ");
	}

	public void end(Method method) {
		System.out.println("end ............ ");
	}

}
