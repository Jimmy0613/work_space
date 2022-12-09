package com.cre.kiosk.product;

import java.util.ArrayList;

import com.cre.util.Cw;

public class Product {
	public String name;
	public int price;
	public int count;
	public String cg;
	public static ArrayList<Product> ap = new ArrayList<>();

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String info() {
		String info = "";
		info = this.name + "(" + Cw.df(this.price) + "원)";
		return info;
	}

	public static void productLoad() {
		ap.clear();
		Dish.getCopy();
		SoftDrink.getCopy();
		Alcohol.getCopy();
		Dessert.getCopy();
		for(Product x: Dish.dishCopy) {
			ap.add(x);
		}
		for(Product x: SoftDrink.softDrinkCopy) {
			ap.add(x);
		}
		for(Product x: Alcohol.alcoholCopy) {
			ap.add(x);
		}
		for(Product x: Dessert.dessertCopy) {
			ap.add(x);
		}
		
	}
}
