package com.cre.kiosk.machine;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cre.kiosk.product.Alcohol;
import com.cre.kiosk.product.Dessert;
import com.cre.kiosk.product.Dish;
import com.cre.kiosk.product.Product;
import com.cre.kiosk.product.SoftDrink;
import com.cre.kiosk.system.Disp;
import com.cre.kiosk.system.Order;
import com.cre.kiosk.system.OrderSheet;
import com.cre.kiosk.system.ProductManagement;
import com.cre.util.Cw;

public class KioskCustomer {
	static Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("###,###");
	static ProductManagement pm = new ProductManagement();

	static ArrayList<Product> productOrdered = new ArrayList<>();


	static int cartCount;
	static int orderCount = 0;
	
	void clear() {
		productOrdered.clear();
		cartCount = 0;
		for (Product x : Product.ap) {
			x.count = 0;
		}

	}

	void run() {
		clear();

		screen0: while (true) {
			Cw.lineWn("1.요리 2.탄산음료 3.주류 4.디저트 (c:주문확인 x:취소)");
			ArrayList<Product> pc = new ArrayList<>();

			String input = sc.next();
			switch (input) {
			case "x":
				Cw.lineWn("안녕히가세요.");
				break screen0;
			case "1":
				pc = Dish.dish;
				Disp.displayMenu(pc, "요리");
				addProductOnCart("요리");
				break;
			case "2":
				pc = SoftDrink.softDrink;
				Disp.displayMenu(pc, "탄산음료");
				addProductOnCart("탄산음료");
				break;
			case "3":
				pc = Alcohol.alcohol;
				Disp.displayMenu(pc, "주류");
				addProductOnCart("주류");
				break;
			case "4":
				pc = Dessert.dessert;
				Disp.displayMenu(pc, "디저트");
				addProductOnCart("디저트");
				break;
			case "c":
				if (cartCount < 1) {
					Cw.line();
					Cw.wn("상품을 담아주세요!");
					break;
				} else {
					cart();
					if (Kiosk.input.equals("o")) {
						break screen0;
					}
				}
			}
		}
		return;

	}

	public static void addProductOnCart(String cg) {
		screenO: while (true) {
			int input;
			ArrayList<Product> pc = new ArrayList<>();
			switch (cg) {
			case "요리":
				pc = Dish.dish;
				break;
			case "탄산음료":
				pc = SoftDrink.softDrink;
				break;
			case "주류":
				pc = Alcohol.alcohol;
				break;
			case "디저트":
				pc = Dessert.dessert;
				break;
			}
			while (true) {
				try {
					input = sc.nextInt();
					break;
				} catch (InputMismatchException ime) {
					sc = new Scanner(System.in);
				}
			}

			switch (input) {
			case 0:
				break screenO;
			default:
				for (int i = 0; i < pc.size(); i++) {
					if (i == (input - 1)) {
						Cw.wn(pc.get(i).info() + "담았습니다.");
						pc.get(i).count++;
						cartCount++;
					}
				}
			}
		}
	}

	public static void cart() {
		while (true) {

			String strOrder = "";
			int sumPrice = 0;
			String input;
			for (Product x : Product.ap) {
				if (x.count != 0) {
					strOrder += Cw.sf(x.name) + Cw.sf(x.count + "") + Cw.sf(Cw.df(x.price * x.count) + "원") + "\n";
					sumPrice += x.price * x.count;
				}
			}

			Cw.lineWn("◆◆◆◆◆◆◆◆◆◆ 주문 내역 ◆◆◆◆◆◆◆◆◆◆");
			Cw.wn(Cw.sf("상품") + Cw.sf("수량") + Cw.sf("가격"));
			Cw.lineWn(strOrder);
			Cw.wn(Cw.sf("총액") + Cw.sf("") + Cw.sf(Cw.df(sumPrice) + "원"));
			Cw.lineWn("(주문하기:o 빼기:x 계속하기:c)");

			input = sc.next();
			switch (input) {
			case "c":
				return;
			case "o":
				KioskCustomer.getOrder();
				return;
			case "x":
				deleteFromCart();
			}
		}
	}

	public static void deleteFromCart() {
		ArrayList<Product> deleteList = new ArrayList<>();
		String str = "";
		int i = 1;
		int input = 0;
		int index = 0;

		for (Product x : Product.ap) {
			if (x.count != 0) {
				deleteList.add(x);
			}
		}

		screenD: while (true) {
			while (true) {
				str = "";
				i = 1;
				Cw.lineWn("취소하실 상품 번호를 입력해주세요. (0:이전으로)");
				for (Product x : deleteList) {
					str += i + "." + Cw.sf(x.name) + Cw.sf(x.count + "") + Cw.sf(Cw.df(x.price * x.count) + "원") + "\n";
					i++;
				}
				Cw.wn(str);
				Cw.line();
				try {
					input = sc.nextInt();
				} catch (InputMismatchException ime) {
					Cw.wn("잘못된 번호입니다.");
					sc = new Scanner(System.in);
				}
				if (input > deleteList.size() || input < 0) {
					Cw.wn("잘못된 번호입니다.");
				} else {
					break;
				}
			}
			if (input == 0) {
				return;
			} else {
				index = input - 1;
			}
			Cw.line();
			Cw.wn(deleteList.get(index).name + " 1개를 취소했습니다.");
			deleteList.get(index).count--;
			cartCount--;
			if (deleteList.get(index).count == 0) {
				deleteList.remove(index);
			}
			if (deleteList.size() == 0)
				break screenD;
		}
	}

	public static void getOrder() {
		for (Product x : Product.ap) {
			if (x.count != 0) {
				productOrdered.add(x);
			}
		}
		@SuppressWarnings("unchecked")
		ArrayList<Product> x = (ArrayList<Product>) productOrdered.clone();
		Order.addOrderOnTodayList(x);
		orderCount++;
		Cw.line();
		Cw.wn("주문이 완료되었습니다. 감사합니다. (주문번호 - " + orderCount + " -)");
		
		Cw.line();
		Kiosk.input = "o";
		OrderSheet.getSales();
		return;

	}
}
