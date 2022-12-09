package com.cre.kiosk.product;

import java.util.ArrayList;

public class Alcohol extends Product {
	public static ArrayList<Product> alcohol = new ArrayList<>();
	public static ArrayList<Product> alcoholCopy = new ArrayList<>();

	public Alcohol(String name, int price) {
		super(name, price);
		this.cg = "주류";
	}
	public static void addAlcohol(String name, int price) {
		alcohol.add(new Alcohol(name, price));
	}
	public static void alcoholLoad() {
		addAlcohol("크림생맥주", 1000);
		addAlcohol("병맥주", 1000);
		addAlcohol("와인한잔", 1500);
		addAlcohol("하이볼", 2000);
	}
	
	@SuppressWarnings("unchecked")
	public static void getCopy() {
		alcoholCopy = (ArrayList<Product>) alcohol.clone();
	}
}
