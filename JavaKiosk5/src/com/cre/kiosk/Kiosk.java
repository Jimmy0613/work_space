package com.cre.kiosk;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.cre.util.Cw;

public class Kiosk {
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("###,###");
	static String input;

	// 전체 상품 목록..
	
	String strOrder;
	int sumPrice;
	static int orderCount = 0;
	static ArrayList<Product> lo = new ArrayList<>(); // 주문 확정된 걸 넘길 때..
	static int c; // 상품 하나 이상 담았는지 카운트 하기 위한 것


	void run() {
		
		//상품 적용, 카테고리별 분류
		Product.getProducts();
		Product.getProductsArrayByCg();
		
		String cg;
		Disp.displayTitle();
		// 장사 시작할 때 키오스크 켜기.. 관리자만 끌 수 있음..(암호로 거름)
		screenOn: while (true) {

			Disp.lineWn("어서오세요. 시작하시려면 아무 버튼이나 눌러주세요.");

			// 이전 손님이 한거 초기화..
			input = sc.next();
			lo.clear();
			c = 0;
			strOrder = "";
			sumPrice = 0;
			for (int i = 0; i < Product.pr.size(); i++) {
				Product.pr.get(i).count = 0;
			}

			// 관리자 모드 들어갈 경우..
			if (input.equals("system")) {

				Disp.lineWn("<관리모드> 암호를 입력하세요.");
				input = sc.next();
				if (input.equals("1234")) {
					Management.managementSystem();
				} else {
					Disp.lineWn("틀렸습니다. 초기 화면으로 돌아갑니다.");
				}

			} else if (input.equals("systemOff")) { // 시스템 종료..

				Disp.lineWn("<시스템종료> 암호를 입력하세요.");
				input = sc.next();
				if (input.equals("1234")) {
					Disp.lineWn("종료합니다.");
					break screenOn;
				} else {
					Disp.lineWn("틀렸습니다. 초기 화면으로 돌아갑니다.");
				}
				// 관리자 모드 아닌것들..
			} else {

				screen0: while (true) {
					Disp.lineWn("1.요리 2.탄산음료 3.주류 4.디저트 c:주문확인 (x:취소)");

					input = sc.next();

					switch (input) {
					case "x":
						Disp.lineWn("안녕히가세요.");
						break screen0;
					case "1":
						cg = "요리";
						Disp.displayProducts(cg);
						break;
					case "2":
						cg = "탄산음료";
						Disp.displayProducts(cg);
						break;
					case "3":
						cg = "주류";
						Disp.displayProducts(cg);
						break;
					case "4":
						cg = "디저트";
						Disp.displayProducts(cg);
						break;
					case "c": // 주문 확인.. 상품 안담았으면 확인 안됨.
						if (c < 1) {
							Disp.lineWn("상품을 담아주세요!");
							break;
						} else {
							Disp.displayCart(); // 카트 보여주기..
							if (input.equals("o")) {
								break screen0; // 주문하기 했으면 주문 완료되어 초기화..
							}
						}
					}
				}

			}
		}
	}

	public static void getOrder() { // 주문 완료하면 관리 시스템에 넘겨 저장함..
		for (Product x : Product.pr) {
			if (x.count != 0) {
				lo.add(x);
			}
		}
		@SuppressWarnings("unchecked")
		ArrayList<Product> x = (ArrayList<Product>) lo.clone(); // 현재 손님이 담은 걸 복제..
		Order.addListOrder(x); // 복제한 걸 관리 시스템 주문 목록에 넘김..
		orderCount++; // 오늘 주문 횟수이자 주문 번호..
		Disp.line();
		Cw.wn("주문이 완료되었습니다. 감사합니다. (주문번호-" + orderCount + "-)");
		Disp.line();
		input = "o";
		return;

	}
}
