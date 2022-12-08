package com.cre.kiosk.system;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cre.kiosk.management.Product;
import com.cre.kiosk.management.ProductManagement;
import com.cre.util.Cw;

public class KioskCustomer {
	static Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("###,###");
	static ProductManagement pm = new ProductManagement();

	static int orderCount = 0;
	static ArrayList<Product> lo = new ArrayList<>();
	static int c;

	void run() {
		lo.clear();
		c = 0;
		for (int i = 0; i < Product.pr.size(); i++) {
			Product.pr.get(i).count = 0;
		}
		screen0: while (true) {
			Disp.lineWn("1.요리 2.탄산음료 3.주류 4.디저트 (c:주문확인 x:취소)");
			String cg;

			String input = sc.next();
			switch (input) {
			case "x":
				Disp.lineWn("안녕히가세요.");
				break screen0;
			case "1":
				cg = "요리";
				Disp.displayMenu(cg);
				addProductOnCart(cg);
				break;
			case "2":
				cg = "탄산음료";
				Disp.displayMenu(cg);
				addProductOnCart(cg);
				break;
			case "3":
				cg = "주류";
				Disp.displayMenu(cg);
				addProductOnCart(cg);
				break;
			case "4":
				cg = "디저트";
				Disp.displayMenu(cg);
				addProductOnCart(cg);
				break;
			case "c":
				if (c < 1) {
					Disp.line();
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
			ArrayList<Product> x = new ArrayList<>();
			switch (cg) {
			case "요리":
				x = Product.dish;
				break;
			case "탄산음료":
				x = Product.softDrink;
				break;
			case "주류":
				x = Product.alcohol;
				break;
			case "디저트":
				x = Product.dessert;
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
				for (int i = 0; i < x.size(); i++) {
					if (i == (input - 1)) {
						
						Cw.wn(x.get(i).info() + "담았습니다.");
						KioskCustomer.c++;
						
						for (int j = 0; j < Product.pr.size(); j++) {
							
							if (x.get(i).name == Product.pr.get(j).name) {
								
								Product.pr.get(j).count++;
							
							}
						}
					
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
			for (Product x : Product.pr) {
				if (x.count != 0) {
					strOrder += Cw.sf(x.name) + Cw.sf(x.count + "") + Cw.sf(Cw.df(x.price * x.count) + "원") + "\n";
					sumPrice += x.price * x.count;
				}
			}

			Disp.lineWn("◆◆◆◆◆◆◆◆◆◆ 주문 내역 ◆◆◆◆◆◆◆◆◆◆");
			Cw.wn(Cw.sf("상품") + Cw.sf("수량") + Cw.sf("가격"));
			Disp.lineWn(strOrder);
			Cw.wn(Cw.sf("총액") + Cw.sf("") + Cw.sf(Cw.df(sumPrice) + "원"));			
			Disp.lineWn("(주문하기:o 빼기:x 계속하기:c)");
			
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

		for (Product x : Product.pr) {
			if (x.count != 0) {
				deleteList.add(x);
			}
		}
		screenD: while (true) {
			while (true) {
				str = "";
				i = 1;
				Disp.lineWn("취소하실 상품 번호를 입력해주세요. (0:이전으로)");
				for (Product x : deleteList) {
					str += i + "." + Cw.sf(x.name) + Cw.sf(x.count + "") + Cw.sf(Cw.df(x.price * x.count) + "원") + "\n";
					i++;
				}
				Cw.wn(str);
				Disp.line();
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
			Disp.line();
			Cw.wn(deleteList.get(index).name + " 1개를 취소했습니다.");
			deleteList.get(index).count--;
			c--;
			if (deleteList.get(index).count == 0) {
				deleteList.remove(index);
			}
			if (deleteList.size() == 0)
				break screenD;
		}
	}

	public static void getOrder() {
		for (Product x : Product.pr) {
			if (x.count != 0) {
				lo.add(x);
			}
		}
		@SuppressWarnings("unchecked")
		ArrayList<Product> x = (ArrayList<Product>) lo.clone();
		Order.addOrderOnTodayList(x);
		orderCount++;
		Disp.line();
		Cw.wn("주문이 완료되었습니다. 감사합니다. (주문번호 - " + orderCount + " -)");
		Disp.line();
		Kiosk.input = "o";
		OrderSheet.getSales();
		return;

	}
}
