package com.cre.kiosk;

import java.util.ArrayList;

import com.cre.util.Cw;

public class Order {
	String name;
	int price;
	int count;
	static int sales = 0;
	public Order(String name, int price, int count){
		this.name = name;
		this.price = price;
		this.count = count;
	}

	static ArrayList<Order[]> list = new ArrayList<Order[]>();

	public static void addListOrder(ArrayList<Product> copy) {
		Order[] orderList = new Order[copy.size()];
		for (int i = 0; i < copy.size(); i++) {
			orderList[i] = new Order(copy.get(i).name, copy.get(i).price, copy.get(i).count);
		}
		list.add(orderList);
	}

	public static void showListOrdered(int listNum) {
		Order[] x = list.get(listNum - 1);
		String strOrder = "";
		int sumPrice = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i].count != 0) {
				strOrder += x[i].name + "      " + x[i].count + "     " + x[i].price * x[i].count + "\n";
				sumPrice += x[i].price * x[i].count;
			}
		}
		Cw.wn("<" + listNum + ">");
		Disp.displayList(strOrder, sumPrice);
		Disp.line();
	}

	public static void getSales() {
		sales = 0;
		for (int i = 0; i < list.size(); i++) {
			Order[] x = list.get(i);
			for (int j = 0; j < x.length; j++) {
				sales += x[j].price * x[j].count;
			}
		}
	}
	
}
