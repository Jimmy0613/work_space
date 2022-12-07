package com.cre.kiosk;

import java.util.Scanner;

import com.cre.util.Cw;

public class Management {
	static Scanner sc = new Scanner(System.in);
//	static int sales = 0;

	public static void managementSystem() {
		String input;

		system0: while (true) {
			Cw.wn("<관리모드> 0:관리 모드 종료 1:주문 내역(개별) 2:주문 내역(전체) 3:매출 4:품목 관리");
			Disp.line();

			input = sc.next();

			switch (input) {
			case "0":
				break system0;
			case "1":
				orderCheck: while (true) {

					Cw.wn("주문 번호를 입력하세요.(0.이전으로)");

					int in = sc.nextInt();

					if (in == 0) {
						break orderCheck;
					} else if (Order.list.size() >= in) {
						Order.showListOrdered(in);
					} else {
						Cw.wn("주문 내역이 없습니다.");
					}
				}
				break;
			case "2":
				for (int i = 1; i <= Order.list.size(); i++) {
					Order.showListOrdered(i);
				}
				break;
			case "3":
				Order.getSales();
				Cw.wn("현재 매출액: " + Cw.df(Order.sales) + "원");
				Disp.line();
				break;
			case "4":
				productManagement();
				break;
			default:
				break;

			}
		}

	}

	public static void productManagement() {
		screenPm: while (true) {
			Disp.lineWn("<품목관리> 0:이전으로 1:품목 조회 2:상품 관리");

			String input = sc.next();
			switch (input) {
			case "0":
				break screenPm;
			case "1":
				Disp.displayProductList();
				break;
			case "2":
				Product.productAED();
				break;
			}
		}
		return;
	}

}
