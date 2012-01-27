package com.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description 产生数值的抽象类
 */
public abstract class NumberGenerator {
	
	private ArrayList observers = new ArrayList();  //存储Observer
	
	/** 添加观察者*/
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	/** 删除观察者*/
	public void delObserver(Observer observer) {
		observers.remove(observer);
	}
	
	/** 通知所有观察者*/
	public void notifyObservers() {
		Iterator it = observers.iterator();
		while(it.hasNext()) {
			Observer o =(Observer) it.next();
			o.update(this);
		}
	}
	
	public abstract int getNumber();//获取数字
	
	public abstract void generate();//产生数字
	
	
}
