package com.tc23.bean;

public class Goods {
	private int id;
	private String name;
	private double price;
	private int stock;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Goods(int id, String name, double price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Goods() {
		super();
	}
	@Override
	public String toString() {
		return "编号" + id + "型号" + name + "价格" + price + "库存" + stock ;
	}
	
	
}
