package com.cre.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

import com.cre.util.Cw;

public class Management {
	static int sales = 0;
	public static void managementSystem() {
		Scanner sc = new Scanner(System.in);
		int input;
		
		system0: while (true) {
			Cw.wn("<관리자 모드> 0.관리자 모드 종료 1.주문 내역(개별) 2.주문 내역(전체) 3.매출");
			Disp.line();
			input = sc.nextInt();
			switch (input) {
			case 0:
				break system0;
			case 1:
				Cw.wn("주문 번호를 입력하세요.");
				input = sc.nextInt();
				if (list.size() >= input) {
				showListOrdered(input);
				} else {
					Cw.wn("주문 내역이 없습니다.");
				}
				break;
			case 2:
				for (int i = 1; i<=list.size(); i++) {
					showListOrdered(i);
				}
				break;
			case 3:
				getSales();
				Cw.wn("현재 매출액: " + Cw.df(sales) + "원");
				Disp.line();
				
			}
		}

	}

	static ArrayList<Order[]> list = new ArrayList<Order[]>();
	
	static void addListOrder(ArrayList<Product> copy) {
		Order[] orderList = new Order[copy.size()];
		for(int i = 0; i<copy.size(); i++) {
			orderList[i] = new Order(copy.get(i).name, copy.get(i).price, copy.get(i).count);
		}
		list.add(orderList);
	}
	
	static void showListOrdered(int listNum) {
		Order[] x = list.get(listNum - 1);
		String strOrder = "";
		int sumPrice = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i].count != 0) {
				strOrder += x[i].name + "      " + x[i].count + "     " + x[i].price * x[i].count
						+ "\n";
				sumPrice += x[i].price * x[i].count;
			}
		}
		Cw.wn("<" + listNum + ">");
		Disp.displayList(strOrder, sumPrice);
		Disp.line();
	}
	
	static void getSales() {
		sales = 0;
		for (int i = 0; i<list.size(); i++) {
			Order[] x = list.get(i);
			for (int j = 0; j<x.length; j++) {
				sales += x[j].price * x[j].count;
			}
		}
	}
}
