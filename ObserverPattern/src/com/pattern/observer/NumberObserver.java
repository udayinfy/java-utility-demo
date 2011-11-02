
package com.pattern.observer;

/** 以数字表示观察者的类*/
public class NumberObserver implements Observer{
	
	public void update(NumberGenerator generator) {
		
		System.out.println("NumberObserver:"+ generator.getNumber());
		
		try {
			Thread.sleep(1000 * 3); //为了能清楚的看到输出，休眠3秒钟。
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
