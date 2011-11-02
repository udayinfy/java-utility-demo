package com.jquery;

public class Stock {
	/*
	 * �������̼�
	 */
	private double yesterday;
	/*
	 * ���쿪�̼�
	 */
	private double today;
	/*
	 * ��ǰ��
	 */
	private double now;
	/*
	 * ��Ʊ����
	 */
	private String name;
	/*
	 * ��Ʊ����
	 */
	private String id;
	
	
	public Stock(double yesterday, double today, String name, String id) {
		super();
		this.yesterday = yesterday;
		this.today = today;
		this.name = name;
		this.id = id;
		// ��ǰ���ڿ���ʱ���ڽ���Ŀ��̼�
		this.now = today;
		
	}
	
	
	public double getYesterday() {
		return yesterday;
	}
	public void setYesterday(double yesterday) {
		this.yesterday = yesterday;
	}
	public double getToday() {
		return today;
	}
	public void setToday(double today) {
		this.today = today;
	}
	public double getNow() {
		return now;
	}
	public void setNow(double now) {
		this.now = now;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {

		return this.name + ":" + this.now;

	}
	

}
