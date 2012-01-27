
package com.pattern.observer;

/** �����ֱ�ʾ�۲��ߵ���*/
public class NumberObserver implements Observer{
	
	public void update(NumberGenerator generator) {
		
		System.out.println("NumberObserver:"+ generator.getNumber());
		
		try {
			Thread.sleep(1000 * 3); //Ϊ��������Ŀ������������3���ӡ�
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
