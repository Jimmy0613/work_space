package com.cre.kiosk.system;

import java.util.ArrayList;
import java.util.Scanner;

import com.cre.kiosk.product.Alcohol;
import com.cre.kiosk.product.Dessert;
import com.cre.kiosk.product.Dish;
import com.cre.kiosk.product.Product;
import com.cre.kiosk.product.SoftDrink;
import com.cre.util.Cw;

public class ProductManagement {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Product> al = new ArrayList<>();

	public void run() {
		productManagement();
	}

	public static void productManagement() {
		screenPm: while (true) {
			Cw.lineWn("<품목관리> 0:이전으로 1:품목 조회 2:상품 관리");

			String input = sc.next();
			switch (input) {
			case "0":
				break screenPm;
			case "1":
				Disp.displayAllProduct();
				break;
			case "2":
				productAED();
				break;
			}
		}
		return;
	}

	static String getCgByInput(String input) {
		switch (input) {
		case "1":
			input = "요리";
			al = Dish.dish;
			return input;
		case "2":
			input = "탄산음료";
			al = SoftDrink.softDrink;
			return input;
		case "3":
			input = "주류";
			al = Alcohol.alcohol;
			return input;
		case "4":
			input = "디저트";
			al = Dessert.dessert;
			return input;
		default:
			return "x";
		}
	}

	public static void productAED() {
		String input;
		String cg = "";
		screenPaed: while (true) {
			Cw.lineWn("<상품관리> 0:이전으로 1:상품추가 2:상품수정 3:상품삭제");
			input = sc.next();
			if (input.equals("0")) {
				break screenPaed;
			} else if (input.equals("1") || input.equals("2")) {
				screenC: while (true) {
					input = sc.next();
					if (input.equals("0")) {
						break screenC;
					} else {
						input = getCgByInput(input);
						if (input != "x") {
							cg = input;
							break screenC;
						} else {
							Cw.wn("다시 입력하세요.");
						}
					}
				}
				switch (input) {
				case "1":
					productAdd(al, cg);
					break;
				case "2":
					productEdit(al, cg);
					break;
				}
			} else if (input.equals("3")) {
				productDelete();
			}
		}
	}

	public static void productAdd(ArrayList<Product> al, String cg) {
		String prName = "";
		int prPrice = 0;
		String input = "";

		screen0: while (true) {
			Cw.lineWn(Cw.sf("상품명") + Cw.sf("가격"));
			Disp.displayProductsByCategory(al);
			Cw.lineWn("<상품추가-" + cg + "> 상품명을 입력하세요. (0:이전으로)");
			input = sc.next();
			if (input.equals("0")) {
				break screen0;
			} else {
				prName = input;
				Cw.lineWn("<상품추가-" + cg + "> 가격을 입력하세요." + "(분류:" + cg + "/상품명:" + prName + ")");
				prPrice = sc.nextInt();

				Cw.lineWn("<상품추가-" + cg + "> 입력 내역");
				Cw.wn("분류     상품     가격");
				Cw.lineWn(cg + "    " + prName + "    " + prPrice);

				Cw.wn("<상품추가-" + cg + "> 상품을 추가하시겠습니까? (o:적용 x:취소)");
				input = sc.next();
				switch (input) {
				case "o":
					Cw.line();
					Cw.wn("상품을 추가했습니다.");
					switch (cg) {
					case "요리":
						Dish.dish.add(new Dish(prName, prPrice));
						break;
					case "탄산음료":
						SoftDrink.softDrink.add(new SoftDrink(prName, prPrice));
						break;
					case "주류":
						Alcohol.alcohol.add(new Alcohol(prName, prPrice));
						break;
					case "디저트":
						Dessert.dessert.add(new Dessert(prName, prPrice));
						break;
					}
					Product.productLoad();
					break;
				case "x":
					Cw.lineWn("취소했습니다.");
					break;
				default:
					Cw.lineWn("잘못된 입력입니다. 취소되었습니다.");
					break;
				}
			}
		}
	}

	public static void productEdit(ArrayList<Product> al, String cg) {
		String prName = "";
		String eName = "";
		int ePrice = 0;
		String input = "";
		screen0: while (true) {
			Disp.displayAllProduct();
			Cw.lineWn("<상품수정> 상품명을 입력하세요. (0:이전으로)");
			input = sc.next();
			if (input.equals("0")) {
				break screen0;
			} else {
				for (Product e : al) {
					if (e.name.equals(input)) {
						Cw.lineWn(e.info());
						prName = input;
					}
				}
				if (prName == "") {
					Cw.wn("존재하지 않는 상품입니다.");
					break screen0;
				}
				Cw.wn("1:상품명 수정 2:가격 수정 (x:취소)");
				input = sc.next();
				switch (input) {
				case "x":
					break screen0;
				case "1":
					Cw.lineWn("상품명을 입력하세요.");
					eName = sc.next();
					Cw.lineWn(eName + "(으)로 수정하시겠습니까? (o:적용 x:취소)");
					input = sc.next();
					switch (input) {
					case "o":
						for (Product e : al) {
							if (e.name.equals(prName)) {
								e.name = eName;
							}
						}
						Product.productLoad();
						Cw.line();
						Cw.wn(eName + "(으)로 수정되었습니다.");
						break;
					case "x":
						Cw.lineWn("취소되었습니다.");
						break;
					default:
						Cw.lineWn("잘못된 입력입니다. 취소되었습니다.");
						break;
					}
					break;

				case "2":
					Cw.lineWn("가격을 입력하세요.");
					ePrice = sc.nextInt();
					Cw.lineWn(ePrice + "원으로 수정하시겠습니까? (o:적용 x:취소)");
					input = sc.next();
					switch (input) {
					case "o":
						for (Product e : al) {
							if (e.name.equals(prName)) {
								e.price = ePrice;
							}
						}
						Product.productLoad();
						Cw.line();
						Cw.wn(ePrice + "원으로 수정되었습니다.");
						break;
					case "x":
						Cw.lineWn("취소되었습니다.");
						break;
					default:
						Cw.lineWn("잘못된 입력입니다. 취소되었습니다.");
						break;
					}
				}
			}
		}
	}

	public static void productDelete() {
		String input = "";

		screen0: while (true) {

			screenI: while (true) {
				String prName = "";
				Disp.displayAllProduct();
				Cw.lineWn("<상품삭제> 상품명을 입력하세요. (0:이전으로)");
				input = sc.next();
				if (input.equals("0")) {
					break screen0;
				} else {
					for (Product d : Product.ap) {
						if (d.name.equals(input)) {
							Cw.lineWn(d.info());
							prName = input;
						}
					}
					if (prName == "") {
						Cw.wn("존재하지 않는 상품입니다.");
						break screenI;
					}
				}
				Cw.wn("삭제하시겠습니까? (적용:o 취소:x)");
				input = sc.next();
				switch (input) {
				case "o":
					for (int i = 0; i < Dish.dish.size(); i++) {
						if (Dish.dish.get(i).name.equals(prName)) {
							Dish.dish.remove(i);
						}
					}
					for (int i = 0; i < SoftDrink.softDrink.size(); i++) {
						if (SoftDrink.softDrink.get(i).name.equals(prName)) {
							SoftDrink.softDrink.remove(i);
						}
					}
					for (int i = 0; i < Alcohol.alcohol.size(); i++) {
						if (Alcohol.alcohol.get(i).name.equals(prName)) {
							Alcohol.alcohol.remove(i);
						}
					}
					for (int i = 0; i < Dessert.dessert.size(); i++) {
						if (Dessert.dessert.get(i).name.equals(prName)) {
							Dessert.dessert.remove(i);
						}
					}
					Product.productLoad();
					Cw.line();
					Cw.wn("삭제되었습니다.");
					break;
				case "x":
					Cw.lineWn("취소했습니다.");
					break;
				default:
					Cw.lineWn("잘못된 입력입니다. 취소되었습니다.");
					break;
				}
			}

		}
	}
}
