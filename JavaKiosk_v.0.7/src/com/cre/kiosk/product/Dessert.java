package com.cre.kiosk.product;

import java.util.ArrayList;

public class Dessert extends Product {
	public static ArrayList<Product> dessert = new ArrayList<>();
	public static ArrayList<Product> dessertCopy = new ArrayList<Product>();
	
	public Dessert(String name, int price) {
		super(name, price);
		this.cg = "디저트";
	}
	public static void addDessert(String name, int price) {
		dessert.add(new Dessert(name, price));
	}
	
	public static void dessertLoad() {
		addDessert("브라우니", 700);
		addDessert("마카롱", 1000);
		addDessert("젤라또", 1000);
		addDessert("초콜릿", 500);
	}
	
	
	@SuppressWarnings("unchecked")
	public static void getCopy() {
		dessertCopy = (ArrayList<Product>) dessert.clone();
	}
}
