package com.cre.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

import com.cre.util.Cw;

public class Disp {
	final static String BAR = "-";
	static Scanner sc = new Scanner(System.in);

	public static void line() {
		for (int i = 1; i <= 64; i++) {
			Cw.w(BAR);
		}
		Cw.wn("");
	}

	public static void lineWn(String str) {
		line();
		Cw.wn(str);
		line();
	}

	public static void displayProducts(String cg) { // 카테고리에 따른 상품들 보여줌..
		ArrayList<Product> x = new ArrayList<>();
		switch (cg) {
		case "요리":
			x = Product.dish;
			break;
		case "탄산음료":
			x = Product.softDrink;
			break;
		case "주류":
			x = Product.alcohol;
			break;
		case "디저트":
			x = Product.dessert;
			break;
		}
		displayProductsByCg(x, cg);
		return;

	}

	public static void displayProductsByCg(ArrayList<Product> x, String cg) {
		Cw.wn("***********************************");
		Cw.wn("************** ◆" + cg +"◆ **************");
		Cw.wn("***********************************");
		Disp.line();
		Cw.wn("이전으로:0");
		for (int i = 0; i < x.size(); i++) {
			Cw.w((i + 1) + ":" + x.get(i).info() + "\n");
		}
		Disp.line();

		screenO: while (true) {
			int input;
			input = sc.nextInt();
			switch (input) {
			case 0:
				break screenO;
			default:
				for (int i = 0; i < x.size(); i++) {
					if (i == (input - 1)) {
						Cw.wn(x.get(i).info() + "담았습니다.");
						Kiosk.c++; // 전체 담은 수임..(상품별x)
						for (int j = 0; j < Product.pr.size(); j++) {
							if (x.get(i).name == Product.pr.get(j).name) {
								Product.pr.get(j).count++;
							}
						}
					}
				}

			}
		}
		return;
	}

	public static void displayTitle() {
		Cw.wn("***********************************");
		Cw.wn("*********** ◆맛있는 식당◆ ***********");
		Cw.wn("***********************************");
	}

	public static void displayProductList() {
		Disp.lineWn("<품목 조회>");
		Disp.lineWn("상품명      분류      가격");
		for (Product x : Product.pr) {
			Cw.wn(x.name + "     " + x.cg + "     " + x.price);
		}
		return;
	}

	// 영수증 형식으로 주문내역 보여주는 거.. 손님도 이걸로 보고 관리자도 이걸로 봄.
	public static void displayList(String strO, int sumP) {

		Disp.lineWn("주문 내역");
		Cw.wn("상품        수량        가격");
		Disp.lineWn(strO);
		Cw.wn("총액: " + Cw.df(sumP) + "원");

	}

	public static void displayCart() {
		String strOrder = "";
		int sumPrice = 0;
		String input;
		for (Product x : Product.pr) { // 하나라도 담은 것의 품명, 수량, 가격을 형식으로 표시..
			if (x.count != 0) {
				strOrder += Cw.sf(x.name, 10) + x.count + Cw.sfr(Cw.df(x.price * x.count), 10) + "원" + "\n";
				sumPrice += x.price * x.count;
			}
		}

		Disp.displayList(strOrder, sumPrice);
		Disp.lineWn("(주문하기:o 계속담기:아무거나)");
		input = sc.next();
		switch (input) {
		case "c":
			return;
		case "o":
			Kiosk.getOrder();
			return;
		}
	}
}
