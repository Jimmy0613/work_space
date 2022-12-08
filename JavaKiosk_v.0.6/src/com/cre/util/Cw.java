package com.cre.util;

import java.text.DecimalFormat;

public class Cw {
	
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
	

}
