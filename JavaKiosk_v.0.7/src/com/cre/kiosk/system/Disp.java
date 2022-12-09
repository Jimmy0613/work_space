package com.cre.kiosk.system;

import java.util.ArrayList;
import java.util.Scanner;

import com.cre.kiosk.product.Product;
import com.cre.util.Cw;

public class Disp {
	static Scanner sc = new Scanner(System.in);

	public static void displayMenu(ArrayList<Product> pc, String cg) {
		Cw.wn("◆◆◆◆◆◆◆◆◆◆ " + cg + " ◆◆◆◆◆◆◆◆◆◆");
		Cw.line();
		Cw.wn("0.이전으로");
		displayProductsByCategory(pc);
		Cw.line();
		return;
	}

	public static void displayTitle() {
		Cw.wn("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼" + Cw.sfr("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼"));
		Cw.wn("◆◆◆◆◆◆◆◆◆◆" + "맛있는 식당" + "◆◆◆◆◆◆◆◆◆◆");
		Cw.wn("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲" + Cw.sfr("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲"));
	}

	public static void displayAllProduct() {
		Cw.line();
		Cw.wn("<상품 목록>");
		Cw.lineWn(Cw.sf("분류") + Cw.sf("상품명") + Cw.sf("가격"));
		for (Product x : Product.ap) {
			Cw.wn(Cw.sf(x.cg) + Cw.sf(x.name) + Cw.sf("" + x.price));
		}
		return;
	}

	public static void displayProductsByCategory(ArrayList<Product> pc) {
		int i = 1;
		for (Product x : pc) {
			Cw.wn(Cw.sf(i + "." + x.name) + Cw.sf(x.price + "원"));
			i++;
		}
		return;
	}

}
