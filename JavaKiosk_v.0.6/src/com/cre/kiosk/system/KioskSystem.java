package com.cre.kiosk.system;

import java.util.Scanner;

import com.cre.kiosk.management.ProductManagement;
import com.cre.util.Cw;

public class KioskSystem {
	static Scanner sc = new Scanner(System.in);
	static ProductManagement pm = new ProductManagement();
	static String password = "1234";

	public void run() {
		managementSystem();
	}

	public static void managementSystem() {
		String input;
		Disp.lineWn("<관리모드> 암호를 입력하세요.");
		input = sc.next();
		if (!input.equals(password)) {
			Disp.lineWn("틀렸습니다. 초기 화면으로 돌아갑니다.");
			return;
		}

		system0: while (true) {
			Cw.wn("<관리모드> 0:관리 모드 종료 1:품목관리 2:주문 내역(개별) 3:주문 내역(전체) 4:매출");
			Disp.line();

			input = sc.next();

			switch (input) {
			case "0":
				break system0;
			case "1":
				pm.run();
				break;
			case "2":
				orderCheck: while (true) {

					Disp.lineWn("<주문 내역> 주문 번호를 입력하세요.(0.이전으로)");
					Cw.wn("오늘 주문 수: " + Order.todayList.size());
					Disp.line();

					int in = sc.nextInt();

					if (in == 0) {
						break orderCheck;
					} else if (Order.todayList.size() >= in) {
						int index = in - 1;
						OrderSheet.getOrderSheetByNumber(index);
					} else {
						Disp.lineWn("주문 내역이 없습니다.");
					}
				}
				break;
			case "3":
				if (Order.todayList.size() == 0) {
					Disp.lineWn("주문 내역이 없습니다.");
				}
				int listNum = 1;
				for (OrderSheet x: OrderSheet.orderSheetList) {
					Disp.lineWn("<주문번호 -" + (listNum) + "- >");
					Cw.wn(x.orders);
					Disp.line();
					listNum++;
				}
				break;
			case "4":
				OrderSheet.getSales();
				Disp.lineWn("현재 매출액: " + Cw.df(OrderSheet.sales) + "원");
				break;
			default:
				break;

			}
		}
	}

	public void systemOff() {
		String input;
		Disp.lineWn("<시스템종료> 암호를 입력하세요.");
		input = sc.next();
		if (input.equals(password)) {
			Disp.lineWn("종료합니다.");
			Kiosk.on = false;
			return;
		} else {
			Disp.lineWn("틀렸습니다. 초기 화면으로 돌아갑니다.");
			return;
		}
	}

}
