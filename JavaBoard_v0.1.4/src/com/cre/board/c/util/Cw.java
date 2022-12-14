package com.cre.board.c.util;

import java.text.DecimalFormat;


public class Cw {
	public static int random(int n) {
		int r = (int)(Math.random()*n + 1);
		return r;
	}
	private final static String BAR = "-";
	public final static String LEO = "π»";
	private static final int LINE_LENGTH = 32;
	
	public static void lineLeo() {
		for(int i = 0; i<LINE_LENGTH+4; i++) {
			w(LEO);
		}
		wn();
	}
	public static void dot() {
		w(LEO);
	}
	public static void w(String str) {
		System.out.print(str);
	}
	public static void wn(String str) {
		System.out.println(str);
	}
	public static void wn(int num) {
		System.out.println(num);
	}
	public static void wn() {
		System.out.println();
	}
	public static void space(int c) {
		for(int i = 0; i<c; i++) {
		w(" ");
		}
	}
	//ν€μ€μ€ν¬μμ μ΄κ±°. κ°κ²©μ 29000λ§κ³  29,000 μ΄λ κ² λμ€κ² νλ €κ³ .
	public static String df(int num) {
		DecimalFormat d = new DecimalFormat("###,###");
		String s = d.format(num);
		return s;
	}
	//String formatter κ²μ.. μ½μμμ νκ³ μμ(λ¬Έμ μ’λ₯,μ€ννκ²½μ λ°λΌ κ³΅λ°± λλΉκ° λ¬λΌμ§..)
	public static String sf(String str, int n) {
		String s=String.format("%-"+n+"s", str);
		return s;
	}
	public static String sfr(String str, int n) {
		String s=String.format("%"+n+"s", str);
		return s;
	}
	
	public static void lineBar() {
		for (int i = 0; i < LINE_LENGTH*2; i++) {
			w(BAR);
		}
		wn();
	}
	
	public static void lineWn(String str) {
		lineBar();
		wn(str);
		lineBar();
	}
	public static void lineWn(int num) { //μ€λ²λ‘λ©μ΄μ£ ?
		lineBar();
		wn(num);
		lineBar();
	}

	
}
