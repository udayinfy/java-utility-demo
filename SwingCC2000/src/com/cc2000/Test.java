package com.cc2000;

import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * CC2000录入功能实现测试
 * 
 * @author zhc
 * 
 */
public class Test {
	
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		final Vector<Student> stuVector = new Vector<Student>();
		for (int i = 0; i < 20; i++) {
			Student student = new Student();
			student.setId( (int)(Math.random() * 10000) + "" );
			student.setName("姓名" + i);
			int n = (int) (Math.random() * 6);
			String[] grades = { "一年级", "二年级", "三年级", "四年级", "五年级", "六年级" };
			student.setGrade(grades[n]);
			student.setAvgScore((int) (Math.random() * 50 + 50) + "");
			student.setProfile("简介" + i);
			stuVector.add(student);
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TypeinFrame(stuVector);
			}
		});
	}

}
