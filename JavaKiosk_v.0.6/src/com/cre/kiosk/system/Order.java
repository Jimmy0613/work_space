package com.cre.kiosk.system;

import java.util.ArrayList;
import java.util.Scanner;

import com.cre.kiosk.management.Product;

public class Order{
	static Scanner sc = new Scanner(System.in);
	int count;
	String name;
	int price;
	Order(String name, int price, int count){
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static ArrayList<Order[]> todayList = new ArrayList<Order[]>();

	public static void addOrderOnTodayList(ArrayList<Product> copy) {
		Order[] orderList = new Order[copy.size()];
		for (int i = 0; i < copy.size(); i++) {
			orderList[i] = new Order(copy.get(i).name, copy.get(i).price, copy.get(i).count);
		}
		todayList.add(orderList);
		OrderSheet.getOrderSheet(orderList);
		
	}

	
}
