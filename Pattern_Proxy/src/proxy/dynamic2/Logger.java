package proxy.dynamic2;

import java.util.Date;

public class Logger {
	
	/**
	 * 根据等级记录日志
	 * @param level
	 * @param context
	 */
	public static void logging(Level level, String context) {
		if (level.equals(Level.INFO)) {
			System.out.println(new Date() + " " + context);
		}
		if (level.equals(Level.DEBUGE)) {
			System.out.println(new Date() + " " + context);
		}
	}

}