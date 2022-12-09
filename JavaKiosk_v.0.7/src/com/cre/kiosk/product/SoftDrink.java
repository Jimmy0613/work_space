package com.cre.kiosk.product;

import java.util.ArrayList;

public class SoftDrink extends Product {
	public static ArrayList<Product> softDrink = new ArrayList<Product>();
	public static ArrayList<Product> softDrinkCopy = new ArrayList<Product>();
	

	public SoftDrink(String name, int price) {
		super(name, price);
		this.cg = "탄산음료";
	}
	
	public static void addSoftDrink(String name, int price) {
		softDrink.add(new SoftDrink(name, price));
	}
	public static void softDrinkLoad() {
		addSoftDrink("콜라", 500);
		addSoftDrink("사이다", 500);
		addSoftDrink("토닉워터", 600);
		addSoftDrink("환타", 500);
	}
	
	@SuppressWarnings("unchecked")
	public static void getCopy() {
		softDrinkCopy = (ArrayList<Product>) softDrink.clone();
	}
	
}
