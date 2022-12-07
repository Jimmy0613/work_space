package com.cre.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

import com.cre.util.Cw;

public class Product {
	String cg;
	String name;
	int price;
	int count = 0;
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Product> pr = new ArrayList<>();
	// 관리에서 실시간으로 넣기위해 스태틱 변수로 선언함.......
//	우선 초기 Product를 생성하고, 키오스크 실행하면 한번에 배열에 넣는 식으로 할 것임
	public static ArrayList<Product> dish = new ArrayList<>();
	public static ArrayList<Product> softDrink = new ArrayList<>();
	public static ArrayList<Product> alcohol = new ArrayList<>();
	public static ArrayList<Product> dessert = new ArrayList<>();

	Product(String cg, String name, int price) {
		this.cg = cg;
		this.name = name;
		this.price = price;
	}

	public String info() {
		String info = "";
		info = this.name + "(" + Cw.df(this.price) + "원)";
		return info;
	}

	public static void addPr(String cg, String name, int price) {
		pr.add(new Product(cg, name, price));
	}

	public static void getProducts() {
		// 첫 오픈때 메뉴들.. 얘네를 삭제하거나, 추가하는걸 관리에서 할 수 있게 할것임..
		addPr("요리", "치킨샐러드", 5000);
		addPr("요리", "감자뇨끼", 6000);
		addPr("요리", "고르곤졸라피자", 7000);
		addPr("요리", "까르보나라", 6500);

		addPr("탄산음료", "콜라", 500);
		addPr("탄산음료", "사이다", 500);
		addPr("탄산음료", "탄산수", 600);

		addPr("주류", "생맥주", 1000);
		addPr("주류", "병맥주", 1000);
		addPr("주류", "테이블와인", 1500);
		addPr("주류", "하이볼", 2000);

		addPr("디저트", "브라우니", 700);
		addPr("디저트", "마카롱", 1000);
		addPr("디저트", "젤라또", 1000);
		addPr("디저트", "초콜릿", 500);

	}

	public static void getProductsArrayByCg() {
		for (Product x : pr) {
			switch (x.cg) {
			case "요리":
				dish.add(x);
				break;
			case "탄산음료":
				softDrink.add(x);
				break;
			case "주류":
				alcohol.add(x);
				break;
			case "디저트":
				dessert.add(x);
				break;
			}
		}
	}

	public static void productAED() {
		String input;
		screenPaed: while (true) {
			Disp.lineWn("<상품관리> 0:이전으로 1:상품추가 2:상품수정 3:상품삭제");
			input = sc.next();
			switch (input) {
			case "0":
				break screenPaed;
			case "1":
				productAdd();
				break;
			case "2":
				productEdit();
				break;
			case "3":
				productDelete();
				break;
			}
		}
	}

	public static void productAdd() {
		String prName = "";
		int prPrice = 0;
		String input = "";
		String cg = "";
		screenC: while (true) {
			Disp.lineWn("<상품관리> 상품분류를 선택하세요. (0:이전으로 1:요리 2:탄산음료 3:주류 4:디저트)");
			input = sc.next();

			switch (input) {
			case "0":
				break screenC;
			case "1":
				cg = "요리";
				break;
			case "2":
				cg = "탄산음료";
				break;
			case "3":
				cg = "주류";
				break;
			case "4":
				cg = "디저트";
				break;
			default:
				break;
			}
			screen0: while (true) {
				Disp.lineWn("<상품추가-" + cg + "> 상품명을 입력하세요. (0:이전으로)");
				input = sc.next();
				if (input.equals("0")) {
					break screen0;
				} else {
					prName = input;
					Disp.lineWn("<상품추가-" + cg + "> 가격을 입력하세요." + "(분류:" + cg + "/상품명:" + prName + ")");
					prPrice = sc.nextInt();

					Disp.lineWn("<상품추가-" + cg + "> 입력 내역");
					Cw.wn("분류     상품     가격");
					Disp.lineWn(cg + "    " + prName + "    " + prPrice);

					Cw.wn("<상품추가-" + cg + "> 상품을 추가하시겠습니까? (o:적용 x:취소)");
					input = sc.next();
					switch (input) {
					case "o":
						Product.pr.add(new Product(cg, prName, prPrice));
						Disp.lineWn("상품을 추가했습니다.");
						switch (cg) {
						case "요리":
							Product.dish.add(new Product(cg, prName, prPrice));
							break;
						case "탄산음료":
							Product.softDrink.add(new Product(cg, prName, prPrice));
							break;
						case "주류":
							Product.alcohol.add(new Product(cg, prName, prPrice));
							break;
						case "디저트":
							Product.dessert.add(new Product(cg, prName, prPrice));
							break;
						}
						break;
					case "x":
						Disp.lineWn("취소했습니다.");
						break;
					default:
						Disp.lineWn("잘못된 입력입니다. 취소되었습니다.");
						break;
					}
				}
			}
		}
	}

	public static void productEdit() {
		String prName = "";
		String eName = "";
		int ePrice = 0;
		String input = "";
		String cg = "";
		screenC: while (true) {
			Disp.lineWn("<상품관리> 상품분류를 선택하세요. (0:이전으로 1:요리 2:탄산음료 3:주류 4:디저트)");
			input = sc.next();

			switch (input) {
			case "0":
				break screenC;
			case "1":
				cg = "요리";
				break;
			case "2":
				cg = "탄산음료";
				break;
			case "3":
				cg = "주류";
				break;
			case "4":
				cg = "디저트";
				break;
			default:
				break;
			}
			screen0: while (true) {
				Disp.lineWn("<상품수정-" + cg + "> 상품명을 입력하세요. (0:이전으로)");
				input = sc.next();
				if (input.equals("0")) {
					break screen0;
				} else {
					for (Product e : Product.pr) {
						if (e.name.equals(input)) {
							Disp.lineWn(e.info());
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
						Disp.lineWn("상품명을 입력하세요.");
						eName = sc.next();
						Disp.lineWn(eName + "으로 수정하시겠습니까? (o:적용 x:취소)");
						input = sc.next();
						switch (input) {
						case "o":
							for (Product e : Product.pr) {
								if (e.name.equals(prName)) {
									e.name = eName;
								}
							}
							Disp.lineWn(eName + "(으)로 수정되었습니다.");
							break;
						case "x":
							Disp.lineWn("취소되었습니다.");
							break;
						default:
							Disp.lineWn("잘못된 입력입니다. 취소되었습니다.");
							break;
						}
						break;

					case "2":
						Disp.lineWn("가격을 입력하세요.");
						ePrice = sc.nextInt();
						Disp.lineWn(ePrice + "원으로 수정하시겠습니까? (o:적용 x:취소)");
						input = sc.next();
						switch (input) {
						case "o":
							for (Product e : Product.pr) {
								if (e.name.equals(prName)) {
									e.price = ePrice;
								}
							}
							Disp.lineWn(ePrice + "원으로 수정되었습니다.");
							break;
						case "x":
							Disp.lineWn("취소되었습니다.");
							break;
						default:
							Disp.lineWn("잘못된 입력입니다. 취소되었습니다.");
							break;
						}
					}
				}
			}
		}
	}

	public static void productDelete() {
		String prName = "";
		String input = "";
		String cg = "";
		screenC: while (true) {
			Disp.lineWn("<상품관리> 상품분류를 선택하세요. (0:이전으로 1:요리 2:탄산음료 3:주류 4:디저트)");
			input = sc.next();

			switch (input) {
			case "0":
				break screenC;
			case "1":
				cg = "요리";
				break;
			case "2":
				cg = "탄산음료";
				break;
			case "3":
				cg = "주류";
				break;
			case "4":
				cg = "디저트";
				break;
			default:
				break;
			}
			screen0: while (true) {
				Disp.lineWn("<상품삭제-" + cg + "> 상품명을 입력하세요. (0:이전으로)");
				input = sc.next();
				if (input.equals("0")) {
					break screen0;
				} else {
					prName = input;
					for (Product d : Product.pr) {
						if (d.name.equals(prName)) {
							Disp.lineWn(d.info());
						}
					}
					Cw.wn("삭제하시겠습니까? (적용:o 취소:x)");
					input = sc.next();
					switch (input) {
					case "o":
						for (int i = 0; i < Product.pr.size(); i++) {
							if (Product.pr.get(i).name.equals(prName)) {
								Product.pr.remove(i);
							}
						}
						switch (cg) {
						case "요리":
							for (int i = 0; i < Product.dish.size(); i++) {
								if (Product.dish.get(i).name.equals(prName)) {
									Product.dish.remove(i);
								}
							}
							break;
						case "탄산음료":
							for (int i = 0; i < Product.softDrink.size(); i++) {
								if (Product.softDrink.get(i).name.equals(prName)) {
									Product.softDrink.remove(i);
								}
							}
							break;
						case "주류":
							for (int i = 0; i < Product.alcohol.size(); i++) {
								if (Product.alcohol.get(i).name.equals(prName)) {
									Product.alcohol.remove(i);
								}
							}
							break;
						case "디저트":
							for (int i = 0; i < Product.dessert.size(); i++) {
								if (Product.dessert.get(i).name.equals(prName)) {
									Product.dessert.remove(i);
								}
							}
							break;
						}
						Disp.lineWn("삭제되었습니다.");
						break;
					case "x":
						Disp.lineWn("취소했습니다.");
						break;
					default:
						Disp.lineWn("잘못된 입력입니다. 취소되었습니다.");
						break;
					}

				}
			}
		}
	}

}
