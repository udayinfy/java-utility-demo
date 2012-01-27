package com.pattern.observer;

/** 以符号表示观察者的类*/
public class SymbolObserver implements Observer{
	
	public void update(NumberGenerator generator) {
		
		System.out.print("SymbolObserver:");
		int count = generator.getNumber();
		
		for(int i = 0 ; i < count; i ++) {
			System.out.print("*^_^*  ");
		}
		
		System.out.println();
		
		try {
			Thread.sleep(1000 * 3);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
}
