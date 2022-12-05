package com.cre.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
	Scanner sc = new Scanner(System.in);
	int touch = -1;
	int sumPrice = 0;
	String listOrder = "";
	ArrayList<String> category = new ArrayList<String>();

	void run() {

		category.add("요리");
		category.add("음료");
		category.add("주류");
		category.add("디저트");
		category.add("주문종료");

		Product[] pr = { new Product("메뉴", 1, "샐러드", 2000), new Product("메뉴", 2, "치킨", 9000),
				new Product("메뉴", 3, "피자", 7000), new Product("메뉴", 4, "햄버거", 4000), new Product("음료", 1, "콜라", 500),
				new Product("음료", 2, "사이다", 500), new Product("음료", 3, "밀크티", 600), new Product("음료", 4, "커피", 700),
				new Product("주류", 1, "소주", 1000), new Product("주류", 2, "맥주", 1000), new Product("주류", 3, "와인", 1500),
				new Product("주류", 4, "하이볼", 2000), new Product("디저트", 1, "쿠키", 300), new Product("디저트", 2, "머핀", 500),
				new Product("디저트", 3, "아이스크림", 500), new Product("디저트", 4, "초콜릿", 400) };

		String listOrder = "";
		int sumPrice = 0;
		screen0: while (true) {
			Util.prl("분류를 선택하세요.");
			for (int i = 0; i < category.size(); i++) {
				Util.pr((i + 1) + "." + category.get(i) + " ");
			}
			
			touch = sc.nextInt();

			switch (touch) {
			case 1:
				Util.prl("메뉴를 선택하세요.(5.이전으로)");
				ArrayList<Product> dish = new ArrayList<Product>();
				for (int i = 0; i < pr.length; i++) {
					if (pr[i].category == "메뉴") {
						Util.pr(pr[i].index + "." + pr[i].info() + " ");
						dish.add(pr[i]);
					}
				}
				screenD: while (true) {
					touch = sc.nextInt();

					switch (touch) {
					case 1:
					case 2:
					case 3:
					case 4:
						for (int i = 0; i<dish.size(); i++) {
							if(dish.get(i).index == touch) {
								Util.prl(dish.get(i).info() + "담았습니다.");
								listOrder += dish.get(i).name + " ";
								sumPrice += dish.get(i).price;
							}
						} break;
					case 5: break screenD;
					}
				} break;

			case 2:

				Util.prl("음료를 선택하세요.(5.이전으로)");
				ArrayList<Product> drink = new ArrayList<Product>();
				for (int i = 0; i < pr.length; i++) {
					if (pr[i].category == "음료") {
						Util.pr(pr[i].index + "." + pr[i].info() + " ");
						drink.add(pr[i]);
					}
				}
				screenDr: while (true) {
					touch = sc.nextInt();

					switch (touch) {
					case 1:
					case 2:
					case 3:
					case 4:
						for (int i = 0; i<drink.size(); i++) {
							if(drink.get(i).index == touch) {
								Util.prl(drink.get(i).info() + "담았습니다.");
								listOrder += drink.get(i).name + " ";
								sumPrice += drink.get(i).price;
							}
						} break;
					case 5: break screenDr;
					}
				} break;
				
			case 3:
				Util.prl("주류를 선택하세요.(5.이전으로)");
				ArrayList<Product> alcohol = new ArrayList<Product>();
				for (int i = 0; i < pr.length; i++) {
					if (pr[i].category == "주류") {
						Util.pr(pr[i].index + "." + pr[i].info() + " ");
						alcohol.add(pr[i]);
					}
				}
				screenA: while (true) {
					touch = sc.nextInt();

					switch (touch) {
					case 1:
					case 2:
					case 3:
					case 4:
						for (int i = 0; i<alcohol.size(); i++) {
							if(alcohol.get(i).index == touch) {
								Util.prl(alcohol.get(i).info() + "담았습니다.");
								listOrder += alcohol.get(i).name + " ";
								sumPrice += alcohol.get(i).price;
							}
						}break;
					case 5: break screenA;
					}
				} break;
				
			case 4:
				Util.prl("디저트를 선택하세요.(5.이전으로)");
				ArrayList<Product> dessert = new ArrayList<Product>();
				for (int i = 0; i < pr.length; i++) {
					if (pr[i].category == "디저트") {
						Util.pr(pr[i].index + "." + pr[i].info() + " ");
						dessert.add(pr[i]);
					}
				}
				screenDe: while (true) {
					touch = sc.nextInt();

					switch (touch) {
					case 1:
					case 2:
					case 3:
					case 4:
						for (int i = 0; i<dessert.size(); i++) {
							if(dessert.get(i).index == touch) {
								Util.prl(dessert.get(i).info() + "담았습니다.");
								listOrder += dessert.get(i).name + " ";
								sumPrice += dessert.get(i).price;
							}
						}break;
					case 5: break screenDe;
					}
				} break;

			case 5:
				Util.prl("총 주문:" + listOrder);
				Util.prl("총 가격:" + sumPrice + "원");
				break screen0;

			}
		}

	}

}
