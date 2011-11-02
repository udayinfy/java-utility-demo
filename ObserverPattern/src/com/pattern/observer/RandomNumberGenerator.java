package com.pattern.observer;

import java.util.Random;

/**
 * @project JavaPattern
 * @author sunnylocus	
 * @verson 1.0.0
 * @date   Aug 27, 2008 1:48:03 PM
 * @description ���ڲ����������֪ͨ�۲��ߵ���
 */
public class RandomNumberGenerator extends NumberGenerator{
	
	private Random random = new Random();//�����������
	private int number;   //���ڴ������

	public void generate() {
		for(int i=0 ; i < 5; i++) {
			number = random.nextInt(10);//����10���ڵ������
			notifyObservers();  //���²��������֣�֪ͨ����ע��Ĺ۲���
		}
	}
	
    /** �������*/
	public int getNumber() {
		return number;
	}
	
}
