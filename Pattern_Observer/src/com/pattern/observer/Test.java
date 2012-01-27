package com.pattern.observer;

public class Test {
	public static void main(String[] args) {
		
		//ʵ�������ֲ�������
		NumberGenerator generator = new RandomNumberGenerator();
		
		//ʵ�����۲���
		Observer observer1 = new NumberObserver();
		Observer observer2 = new SymbolObserver();
		
		//ע��۲���
		generator.addObserver(observer1);
		generator.addObserver(observer2);
		
		generator.generate(); //��������
	}
}
