package com.cre.util;

import java.text.DecimalFormat;


public class Cw {
	public static int random(int n) {
		int r = (int)(Math.random()*n + 1);
		return r;
	}
	private final static String BAR = "-";
	private final static String DOT = "🦎";
	private static final int LINE_LENGTH = 32;
	
	public static void lineCre() {
		for(int i = 0; i<LINE_LENGTH; i++) {
			w(DOT);
		}
		wn();
	}
	public static void dot() {
		w(DOT);
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
	public static String df(int num) {
		DecimalFormat d = new DecimalFormat("###,###");
		String s = d.format(num);
		return s;
	}
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
	public static void lineWn(int num) {
		lineBar();
		wn(num);
		lineBar();
	}

	
}
