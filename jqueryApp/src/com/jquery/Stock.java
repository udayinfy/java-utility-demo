package com.jquery;

public class Stock {
	/*
	 * 昨天收盘价
	 */
	private double yesterday;
	/*
	 * 今天开盘价
	 */
	private double today;
	/*
	 * 当前价
	 */
	private double now;
	/*
	 * 股票名称
	 */
	private String name;
	/*
	 * 股票代码
	 */
	private String id;
	
	
	public Stock(double yesterday, double today, String name, String id) {
		super();
		this.yesterday = yesterday;
		this.today = today;
		this.name = name;
		this.id = id;
		// 当前价在开盘时等于今天的开盘价
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
