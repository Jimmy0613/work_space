package com.cre.kiosk.management;

import java.util.ArrayList;
import com.cre.util.Cw;

public class Product {
	public String cg;
	public String name;
	public int price;
	public int count = 0;
	
	public static ArrayList<Product> pr = new ArrayList<>();

	public static ArrayList<Product> dish = new ArrayList<>();
	public static ArrayList<Product> softDrink = new ArrayList<>();
	public static ArrayList<Product> alcohol = new ArrayList<>();
	public static ArrayList<Product> dessert = new ArrayList<>();

	Product(String cg, String name, int price) {
		this.cg = cg;
		this.name = name;
		this.price = price;
		
		switch (this.cg) {
		case "요리":
			dish.add(this);
			break;
		case "탄산음료":
			softDrink.add(this);
			break;
		case "주류":
			alcohol.add(this);
			break;
		case "디저트":
			dessert.add(this);
			break;
		}
	}

	public String info() {
		String info = "";
		info = this.name + "(" + Cw.df(this.price) + "원)";
		return info;
	}

	public static void addPr(String cg, String name, int price) {
		pr.add(new Product(cg, name, price));
	}

	public static void getProducts() {
		// 첫 오픈때 메뉴들.. 얘네를 삭제하거나, 추가하는걸 관리에서 할 수 있게 할것임..
		addPr("요리", "치킨샐러드", 5000);
		addPr("요리", "감자뇨끼", 6000);
		addPr("요리", "고르곤졸라피자", 7000);
		addPr("요리", "까르보나라", 6500);

		addPr("탄산음료", "콜라", 500);
		addPr("탄산음료", "사이다", 500);
		addPr("탄산음료", "탄산수", 600);

		addPr("주류", "생맥주", 1000);
		addPr("주류", "병맥주", 1000);
		addPr("주류", "테이블와인", 1500);
		addPr("주류", "하이볼", 2000);

		addPr("디저트", "브라우니", 700);
		addPr("디저트", "마카롱", 1000);
		addPr("디저트", "젤라또", 1000);
		addPr("디저트", "초콜릿", 500);

	}



	

}
