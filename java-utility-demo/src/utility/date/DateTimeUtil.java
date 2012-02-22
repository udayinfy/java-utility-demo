package utility.date;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 * @author zhc
 *
 */
public class DateTimeUtil {

	/**
	 * 获取当前时间，格式为YYYY-MM-DD HH24:MI:SS
	 * @return
	 */
	public static String getCurrentDateTime(){
		return String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());
	}
	
	/**
	 * 得到明天的日期
	 * @return
	 */
	public static Date getTomorrow() {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 1);
		
		return calendar.getTime();
	}
	
}
