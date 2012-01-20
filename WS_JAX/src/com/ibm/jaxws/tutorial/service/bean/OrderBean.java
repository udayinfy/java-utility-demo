package com.ibm.jaxws.tutorial.service.bean;

public class OrderBean {

	private Customer customer;

	private Address shippingAddress;

	private OrderItem[] orderItems;

	private String orderId;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAaddress) {
		this.shippingAddress = shippingAaddress;
	}

	public OrderItem[] getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(OrderItem[] orderItems) {
		this.orderItems = orderItems;
	}

}
