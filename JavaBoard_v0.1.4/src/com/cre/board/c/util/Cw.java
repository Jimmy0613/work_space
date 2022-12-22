package com.cre.board.c.util;

import java.text.DecimalFormat;


public class Cw {
	public static int random(int n) {
		int r = (int)(Math.random()*n + 1);
		return r;
	}
	private final static String BAR = "-";
	public final static String LEO = "👻";
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
	//키오스크에서 쓴거. 가격을 29000말고 29,000 이렇게 나오게 하려고.
	public static String df(int num) {
		DecimalFormat d = new DecimalFormat("###,###");
		String s = d.format(num);
		return s;
	}
	//String formatter 검색.. 콘솔에서 한계 있음(문자 종류,실행환경에 따라 공백 너비가 달라짐..)
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
	public static void lineWn(int num) { //오버로딩이죠?
		lineBar();
		wn(num);
		lineBar();
	}

	
}
