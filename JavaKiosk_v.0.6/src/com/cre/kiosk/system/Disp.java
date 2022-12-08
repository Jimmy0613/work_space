package com.cre.kiosk.system;

import java.util.Scanner;

import com.cre.kiosk.management.Product;
import com.cre.util.Cw;

public class Disp {
	final static String BAR = "-";
	static Scanner sc = new Scanner(System.in);

	public static void line() {
		for (int i = 1; i <= 64; i++) {
			Cw.w(BAR);
		}
		Cw.wn();
	}
	
	public static String lineStr() {
		String str = "";
		for (int i = 1; i <= 64; i++) {
			str += BAR;
		}
		str += "\n";
		return str;
	}

	public static void lineWn(String str) {
		line();
		Cw.wn(str);
		line();
	}

	public static void displayMenu(String cg) {
		Cw.wn("◆◆◆◆◆◆◆◆◆◆ " + cg + " ◆◆◆◆◆◆◆◆◆◆");
		Disp.line();
		Cw.wn("0.이전으로");
		displayProductsByCategory(cg);
		Disp.line();
		return;
	}

	public static void displayTitle() {
		Cw.wn("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼" + Cw.sfr("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼"));
		Cw.wn("◆◆◆◆◆◆◆◆◆◆" + "맛있는 식당" + "◆◆◆◆◆◆◆◆◆◆");
		Cw.wn("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲" + Cw.sfr("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲"));
	}

	public static void displayAllProduct() {
		Disp.line();
		Cw.wn("<품목 조회>");
		Disp.lineWn(Cw.sf("분류") + Cw.sf("상품명") + Cw.sf("가격"));
		for (Product x : Product.dish) {
			Cw.wn(Cw.sf(x.cg) + Cw.sf(x.name) + Cw.sf("" + x.price));
		}
		for (Product x : Product.softDrink) {
			Cw.wn(Cw.sf(x.cg) + Cw.sf(x.name) + Cw.sf("" + x.price));
		}
		for (Product x : Product.alcohol) {
			Cw.wn(Cw.sf(x.cg) + Cw.sf(x.name) + Cw.sf("" + x.price));
		}
		for (Product x : Product.dessert) {
			Cw.wn(Cw.sf(x.cg) + Cw.sf(x.name) + Cw.sf("" + x.price));
		}
		return;
	}

	public static void displayProductsByCategory(String cg) {
		int i = 1;
		for (Product x : Product.pr) {
			if (x.cg.equals(cg)) {
				Cw.wn(Cw.sf(i + "." + x.name) + Cw.sf(x.price + ""));
				i++;
			}
		}
		return;
	}



}
