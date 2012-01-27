package com.pattern.observer;

/** �Է��ű�ʾ�۲��ߵ���*/
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
