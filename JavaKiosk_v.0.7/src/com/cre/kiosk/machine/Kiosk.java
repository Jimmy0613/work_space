package com.cre.kiosk.machine;

import java.util.Scanner;

import com.cre.kiosk.product.Alcohol;
import com.cre.kiosk.product.Dessert;
import com.cre.kiosk.product.Dish;
import com.cre.kiosk.product.Product;
import com.cre.kiosk.product.SoftDrink;
import com.cre.kiosk.system.Disp;
import com.cre.kiosk.system.KioskSystem;
import com.cre.util.Cw;

public class Kiosk {

	KioskCustomer kcOn = new KioskCustomer();
	KioskSystem ksOn = new KioskSystem();
	Scanner sc = new Scanner(System.in);
	public static boolean on = true;
	public static String input = "";

	void run() throws CloneNotSupportedException {
		Dish.dishLoad();
		SoftDrink.softDrinkLoad();
		Alcohol.alcoholLoad();
		Dessert.dessertLoad();
		//상품 넣기
		Product.productLoad();
		
		
		while (on) {
			//초기 화면
			Disp.displayTitle();
			Cw.lineWn("시작하시려면 아무 버튼이나 눌러주세요.");
			
			input = sc.next();
			
			//관리모드
			if (input.equals("system")) {
				
				ksOn.managementSystem();
				
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
