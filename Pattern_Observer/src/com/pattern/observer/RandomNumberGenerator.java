package com.pattern.observer;

import java.util.Random;

/**
 * @project JavaPattern
 * @author sunnylocus	
 * @verson 1.0.0
 * @date   Aug 27, 2008 1:48:03 PM
 * @description 用于产生随机数及通知观察者的类
 */
public class RandomNumberGenerator extends NumberGenerator{
	
	private Random random = new Random();//随机数产生器
	private int number;   //用于存放数字

	public void generate() {
		for(int i=0 ; i < 5; i++) {
			number = random.nextInt(10);//产生10以内的随机数
			notifyObservers();  //有新产生的数字，通知所有注册的观察者
		}
	}
	
    /** 获得数字*/
	public int getNumber() {
		return number;
	}
	
}
