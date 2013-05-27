package date20130527.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import date20130527.util.WordDealUtil;


public class TestWordDealUtil_1 { 
	
	 // ���� null ʱ�Ĵ������
	 @Test public void wordFormat4DBNull(){ 
		 String target = null; 
		 String result = WordDealUtil.wordFormat4DB(target); 
		 assertNull(result);
	 } 
	
	 // ���Կ��ַ����Ĵ������
	 @Test public void wordFormat4DBEmpty(){ 
		 String target = ""; 
		 String result = WordDealUtil.wordFormat4DB(target); 
		
		 assertEquals("", result); 
	 } 

	 // ���Ե�����ĸ��дʱ�����
	 @Test public void wordFormat4DBegin(){ 
		 String target = "EmployeeInfo"; 
		 String result = WordDealUtil.wordFormat4DB(target); 
		
		 assertEquals("employee_info", result); 
	 } 
	
	 // ���Ե�β��ĸΪ��дʱ�����
	 @Test public void wordFormat4DBEnd(){ 
		 String target = "employeeInfoA"; 
		 String result = WordDealUtil.wordFormat4DB(target); 
		
		 assertEquals("employee_info_a", result); 
	 } 
	
	 // ���Զ��������ĸ��дʱ�����
	 @Test public void wordFormat4DBTogether(){ 
		 String target = "employeeAInfo"; 
		 String result = WordDealUtil.wordFormat4DB(target); 
		
		 assertEquals("employee_a_info", result); 
	 } 
} 