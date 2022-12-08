package com.cre.kiosk.system;

import java.util.ArrayList;
import java.util.Scanner;

import com.cre.util.Cw;

public class OrderSheet {
	String orders;
	public static ArrayList<OrderSheet> orderSheetList = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	boolean order = true;
	int sumPrice;
	public static int sales = 0;

	public OrderSheet(String orders, int sumPrice) {
		this.orders = orders;
		this.sumPrice = sumPrice;
	}

	

	public static void getSales() {
		sales = 0;
		for(OrderSheet x: OrderSheet.orderSheetList) {
			sales += x.sumPrice; 
		}
	}

	public static void getOrderSheet(Order[] orderList) {
		String strOrder = "";
		int sumPrice = 0;
		for (Order x : orderList) {
			strOrder += Cw.sf(x.name) + Cw.sf(x.count + "") + Cw.sf(x.price * x.count + "") + "\n";
			sumPrice += x.price * x.count;
		}

		strOrder = Cw.sf("상품") + Cw.sf("수량") + Cw.sf("가격") + "\n" + Disp.lineStr() + strOrder + Disp.lineStr() + Cw.sf("총액") + Cw.sf("")
				+ Cw.sf(Cw.df(sumPrice) + "원");

		orderSheetList.add(new OrderSheet(strOrder, sumPrice));

	}

	public static void getOrderSheetByNumber(int listNum) {

		Disp.lineWn("<주문번호 -" + (listNum + 1) + "- > (0:이전으로 x:주문취소)");
		Cw.wn(orderSheetList.get(listNum).orders);
		Disp.line();
		String input = sc.next();

		switch (input) {
		case "0":
			break;
		case "x":
			if (orderSheetList.get(listNum).order == true) {
			cancelOrder(listNum);
			} else {
				Cw.wn("이미 취소된 주문입니다.");
			}
		}
	}

	public static void cancelOrder(int listNum) {
		Cw.wn("<!> 해당 주문을 취소하시겠습니까? (o:네 x:아니오)");
		String input = sc.next();
		switch (input) {
		case "x":
			Cw.wn("이전으로 돌아갑니다.");
			break;
		case "o":
			orderSheetList.get(listNum).orders = "<취소된 주문입니다.>" + "\n" + Disp.lineStr()
					+ orderSheetList.get(listNum).orders;
			orderSheetList.get(listNum).order = false;
			orderSheetList.get(listNum).sumPrice = 0;
			getSales();
			Cw.wn("주문을 취소했습니다.");
		}
	}
}
