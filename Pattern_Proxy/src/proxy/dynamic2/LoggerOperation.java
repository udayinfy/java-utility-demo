package proxy.dynamic2;

import java.lang.reflect.Method;

public class LoggerOperation {

	public void start(Method method) {
		Logger.logging(Level.DEBUGE, method.getName() + " Method Start.");
	}

	public void end(Method method) {
		Logger.logging(Level.INFO, method.getName() + " Method end.");
	}

}
