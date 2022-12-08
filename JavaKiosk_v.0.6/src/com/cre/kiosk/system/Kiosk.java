package com.cre.kiosk.system;

import java.util.Scanner;

import com.cre.kiosk.management.Product;

public class Kiosk {

	KioskCustomer kcOn = new KioskCustomer();
	KioskSystem ksOn = new KioskSystem();
	Scanner sc = new Scanner(System.in);
	public static boolean on = true;
	public static String input = "";

	void run() {
		//상품 넣기
		Product.getProducts();
		
		
		while (on) {
			//초기 화면
			Disp.displayTitle();
			Disp.lineWn("시작하시려면 아무 버튼이나 눌러주세요.");
			
			input = sc.next();
			
			//관리모드
			if (input.equals("system")) {
				
				ksOn.run();
				
			//시스템 종료
			} else if (input.equals("systemOff")) {
				
				ksOn.systemOff();
				
			//일반 손님
			} else {
				
				kcOn.run();
			
			}
		}
	}
}
