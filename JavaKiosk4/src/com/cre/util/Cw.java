package com.cre.util;

import java.text.DecimalFormat;

public class Cw {
	
	public static void w(String str) {
		System.out.print(str);
	}
	public static void wn(String str) {
		System.out.println(str);
	}
	public static String df(int num) {
		DecimalFormat d = new DecimalFormat("###,###");
		String s = d.format(num);
		return s;
	}
	public static String sf(String str, int t) {
		String s=String.format("%-"+t+"s", str);
		return s;
	}
	public static String sfr(String str, int t) {
		String s=String.format("%"+t+"s", str);
		return s;
	}
	

}
