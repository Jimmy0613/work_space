package com.cre.util;

import com.cre.Turn;

public class Util {
	public static int random(int n) {
		int r = (int)(Math.random()*n + 1);
		return r;
	}
	
	public static void br() {
		System.out.println();
	}
	
	public static void pr(String str) {
		System.out.print(str);
	}
	public static void prl(String str) {
		System.out.println(str);
	}
	public static void controlInfo() {
		prl("[조작법]  0:턴진행/전투 1:동쪽 2:서쪽 3:남쪽 4:북쪽 5:위쪽 6:아래쪽 x:종료 (현재 턴:" + Turn.turn + ")");
	}
}
