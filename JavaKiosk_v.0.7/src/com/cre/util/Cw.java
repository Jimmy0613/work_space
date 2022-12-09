package com.cre.util;

import java.text.DecimalFormat;

public class Cw {
	final static String BAR = "-";

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
	public static String df(int num) {
		DecimalFormat d = new DecimalFormat("###,###");
		String s = d.format(num);
		return s;
	}
	public static String sf(String str) {
		String s=String.format("%-"+15+"s", str);
		return s;
	}
	public static String sfr(String str) {
		String s=String.format("%"+15+"s", str);
		return s;
	}
	
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
	

}
