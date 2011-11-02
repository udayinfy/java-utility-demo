package com.cc2000;

import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * CC2000¼�빦��ʵ�ֲ���
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
			student.setName("����" + i);
			int n = (int) (Math.random() * 6);
			String[] grades = { "һ�꼶", "���꼶", "���꼶", "���꼶", "���꼶", "���꼶" };
			student.setGrade(grades[n]);
			student.setAvgScore((int) (Math.random() * 50 + 50) + "");
			student.setProfile("���" + i);
			stuVector.add(student);
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TypeinFrame(stuVector);
			}
		});
	}

}
