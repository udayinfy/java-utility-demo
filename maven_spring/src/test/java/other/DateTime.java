package other;

import java.util.Date;

public class DateTime {
	
	public static String getDateTimeStr(){
		return String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", new Date());
	}

}
