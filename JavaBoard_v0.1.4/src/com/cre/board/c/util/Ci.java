package com.cre.board.c.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	static public String rl(String comment) {
		Cw.w(comment + " : ");
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	//입력받은게 순수 int인지 확인하는 함수
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}
}
