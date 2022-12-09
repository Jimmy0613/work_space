package com.cre.kiosk.system;

import java.util.Scanner;

import com.cre.kiosk.machine.Kiosk;
import com.cre.util.Cw;

public class KioskSystem {
	static Scanner sc = new Scanner(System.in);
	static ProductManagement pm = new ProductManagement();
	static String password = "1234";

	public void managementSystem() {
		String input;
		Cw.lineWn("<관리모드> 암호를 입력하세요.");
		input = sc.next();
		if (!input.equals(password)) {
			Cw.lineWn("틀렸습니다. 초기 화면으로 돌아갑니다.");
			return;
		}

		system0: while (true) {
			Cw.wn("<관리모드> 0:관리 모드 종료 1:품목관리 2:주문 내역(개별) 3:주문 내역(전체) 4:매출");
			Cw.line();

			input = sc.next();

			switch (input) {
			case "0":
				break system0;
			case "1":
				pm.run();
				break;
			case "2":
				orderCheck: while (true) {

					Cw.lineWn("<주문 내역> 주문 번호를 입력하세요.(0.이전으로)");
					Cw.wn("오늘 주문 수: " + OrderSheet.orderSheetList.size());
					Cw.line();

					int in = sc.nextInt();

					if (in == 0) {
						break orderCheck;
					} else if (OrderSheet.orderSheetList.size() >= in) {
						int index = in - 1;
						OrderSheet.getOrderSheetByNumber(index);
					} else {
						Cw.lineWn("주문 내역이 없습니다.");
					}
				}
				break;
			case "3":
				if (OrderSheet.orderSheetList.size() == 0) {
					Cw.lineWn("주문 내역이 없습니다.");
				}
				int listNum = 1;
				for (OrderSheet x: OrderSheet.orderSheetList) {
					Cw.lineWn("<주문번호 -" + (listNum) + "- >");
					Cw.wn(x.orders);
					Cw.line();
					listNum++;
				}
				break;
			case "4":
				OrderSheet.getSales();
				Cw.lineWn("현재 매출액: " + Cw.df(OrderSheet.sales) + "원");
				break;
			default:
				break;

			}
		}
	}

	public void systemOff() {
		String input;
		Cw.lineWn("<시스템종료> 암호를 입력하세요.");
		input = sc.next();
		if (input.equals(password)) {
			Cw.lineWn("종료합니다.");
			Kiosk.on = false;
			return;
		} else {
			Cw.lineWn("틀렸습니다. 초기 화면으로 돌아갑니다.");
			return;
		}
	}

}
