package com.cre.kiosk;

public class Product {
	String category;
	String name;
	int price;
	int count = 0;
	int index = 0;
	
	Product(String category, int index, String name, int price){
		this.category = category;
		this.name = name;
		this.price = price;
		this.index = index;
	}
	
	public String info() {
		String info = "";
		info = this.name + "(" + this.price + "원)";
		return info;
	}
	

}
