package com.cre.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ci {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	static public String r() {
		return sc.next();
	}

	static public String r(String comment) {
		Cw.w(comment + " : ");
		return sc.next();
	}

	static public int n() {
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException ime) {
				sc = new Scanner(System.in);
			}
		}
	}

	static public String rl(String comment) {
		Cw.w(comment + " : ");
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}
}
