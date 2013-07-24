package demo.spring3.quartz;

import java.util.Calendar;

public class RunMeTask {

	public void printMe() {
		System.out.println(String.format(
				"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL", Calendar
						.getInstance().getTime())
				+ " Spring 3 + Quartz 1.8.6 ~");
	}

}