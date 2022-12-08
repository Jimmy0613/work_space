package com.cre.kiosk.management;

import java.util.Scanner;

import com.cre.kiosk.system.Disp;
import com.cre.util.Cw;

public class ProductManagement {
	static Scanner sc = new Scanner(System.in);

	public void run() {
		productManagement();
	}

	public static void productManagement() {
		screenPm: while (true) {
			Disp.lineWn("<품목관리> 0:이전으로 1:품목 조회 2:상품 관리");

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

	static String getCgByInput(String input) {
		switch (input) {
		case "1":
			input = "요리";
			return input;
		case "2":
			input = "탄산음료";
			return input;
		case "3":
			input = "주류";
			return input;
		case "4":
			input = "디저트";
			return input;
		default:
			return "x";
		}
	}

	public static void productAdd() {
		String prName = "";
		int prPrice = 0;
		String input = "";
		String cg = "";
		screenC: while (true) {
			Disp.lineWn("<상품추가> 상품분류를 선택하세요. (0:이전으로 1:요리 2:탄산음료 3:주류 4:디저트)");
			screenCg: while (true) {
				input = sc.next();
				switch (input) {
				case "0":
					break screenC;
				default:
					input = getCgByInput(input);
					if (input != "x") {
						cg = input;
						break screenCg;
					} else {
						Cw.wn("다시 입력하세요.");
						break;
					}
				}
			}

			screen0: while (true) {
				Disp.lineWn(Cw.sf("상품명") + Cw.sf("가격"));
				Disp.displayProductsByCategory(cg);
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
						Disp.line();
						Cw.wn("상품을 추가했습니다.");
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
			Disp.lineWn("<상품수정> 상품분류를 선택하세요. (0:이전으로 1:요리 2:탄산음료 3:주류 4:디저트)");
			screenCg: while (true) {
				input = sc.next();
				switch (input) {
				case "0":
					break screenC;
				default:
					input = getCgByInput(input);
					if (input != "x") {
						cg = input;
						break screenCg;
					} else {
						Cw.wn("다시 입력하세요.");
						break;
					}
				}
			}
			screen0: while (true) {
				Disp.displayProductsByCategory(cg);
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
						Disp.lineWn(eName + "(으)로 수정하시겠습니까? (o:적용 x:취소)");
						input = sc.next();
						switch (input) {
						case "o":
							for (Product e : Product.pr) {
								if (e.name.equals(prName)) {
									e.name = eName;
								}
							}
							Disp.line();
							Cw.wn(eName + "(으)로 수정되었습니다.");
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
							Disp.line();
							Cw.wn(ePrice + "원으로 수정되었습니다.");
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
			Disp.lineWn("<상품삭제> 상품분류를 선택하세요. (0:이전으로 1:요리 2:탄산음료 3:주류 4:디저트)");
			screenCg: while (true) {
				input = sc.next();
				switch (input) {
				case "0":
					break screenC;
				default:
					input = getCgByInput(input);
					if (input != "x") {
						cg = input;
						break screenCg;
					} else {
						Cw.wn("다시 입력하세요.");
						break;
					}
				}
			}
			screen0: while (true) {
				Disp.displayProductsByCategory(cg);
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
						Disp.line();
						Cw.wn("삭제되었습니다.");
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
