package com.cre.kiosk;

import com.cre.util.Cw;

public class Disp {
	final static String BAR = "-";
	
	public static void line() {
		for(int i = 1; i<=64; i++) {
			Cw.w(BAR);
		}
		Cw.wn("");
	}
	public static void displayList(String strO, int sumP) {
		
		Disp.line();
		Cw.wn("주문 내역");
		Disp.line();
		Cw.wn("상품     수량     가격");
		Disp.line();
		Cw.w(strO);
		Disp.line();
		Cw.wn("총액:        " + Cw.df(sumP) + "원");
		Disp.line();

	}
}
