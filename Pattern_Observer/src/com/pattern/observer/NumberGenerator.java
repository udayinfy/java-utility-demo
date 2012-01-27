package com.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description ������ֵ�ĳ�����
 */
public abstract class NumberGenerator {
	
	private ArrayList observers = new ArrayList();  //�洢Observer
	
	/** ��ӹ۲���*/
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	/** ɾ���۲���*/
	public void delObserver(Observer observer) {
		observers.remove(observer);
	}
	
	/** ֪ͨ���й۲���*/
	public void notifyObservers() {
		Iterator it = observers.iterator();
		while(it.hasNext()) {
			Observer o =(Observer) it.next();
			o.update(this);
		}
	}
	
	public abstract int getNumber();//��ȡ����
	
	public abstract void generate();//��������
	
	
}
