package com.cre.kiosk.product;

import java.util.ArrayList;

public class Dish extends Product {
	public static ArrayList<Product> dish = new ArrayList<>();
	public static ArrayList<Product> dishCopy = new ArrayList<>();
	public Dish(String name, int price) {
		super(name, price);
		this.cg = "요리";
	}
	
	public static void dishLoad() {
		dish.add(new Dish("치킨샐러드", 5000));
		dish.add(new Dish("감자뇨끼", 6000));
		dish.add(new Dish("고르곤졸라피자", 7000));
		dish.add(new Dish("까르보나라", 6500));
	}
	
	@SuppressWarnings("unchecked")
	public static void getCopy() {
		dishCopy = (ArrayList<Product>) dish.clone();
	}
}
