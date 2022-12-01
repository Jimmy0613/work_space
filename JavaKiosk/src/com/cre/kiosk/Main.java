package com.cre.kiosk;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int touch = -1;
		Category food = new Category("요리");
		Category drink = new Category("음료");
		Category dessert = new Category("디저트");
		
		Food chicken = new Food("치킨", 12000);
		Food pizza = new Food("피자", 9000);
		Food burger = new Food("햄버거", 4000);
		
		Drink coke = new Drink("콜라", 500);
		Drink cider = new Drink("사이다", 400);
		Drink cokeZero = new Drink("제로콜라", 700);
		
		Dessert icecream = new Dessert("아이스크림", 1000);
		Dessert cottonCandy = new Dessert("솜사탕", 800);
		Dessert chocolate = new Dessert("초콜릿", 900);
		

		String list = " ";
		int count = 0;
		int sum = 0;
		
		kiosk: while(true) {
			
			System.out.println("분류를 선택해주세요.");
			System.out.println("1." + food.name + " 2." + drink.name + " 3." + dessert.name + " 4.종료");
						
			touch = sc.nextInt();
			
			switch(touch) {
			
			case 1:
				
				food: while(true) {
				System.out.println("요리를 선택해주세요.");
				System.out.println("0.이전으로 1." + chicken.name + "(" + chicken.price + ") 2." + pizza.name + "(" + pizza.price + ") 3." + burger.name + "(" + burger.price + ") 4.종료");

				touch = sc.nextInt();
				switch(touch) {
				case 0: 
					break food;
				case 1:
					count++;
					System.out.println(chicken.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
					sum = sum + chicken.price;
					list = list + chicken.name + " ";
					break;
				case 2:
					count++;
					System.out.println(pizza.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
					sum = sum + pizza.price;
					list = list + pizza.name + " ";
					break;
				case 3:
					count++;
					System.out.println(burger.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
					sum = sum + burger.price;
					list = list + burger.name + " ";
					break;
				case 4:
					System.out.println("안녕히 가세요.");
					break kiosk;
				}
				}
				break;
				
			case 2:
				
				drink: while(true) {
					System.out.println("음료를 선택해주세요.");
					System.out.println("0.이전으로 1." + coke.name + "(" + coke.price + ") 2." + cider.name + "(" + cider.price + ") 3." + cokeZero.name + "(" + cokeZero.price + ") 4.종료");

					touch = sc.nextInt();
					switch(touch) {
					case 0: 
						break drink;
					case 1:
						count++;
						System.out.println(coke.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
						sum = sum + coke.price;
						list = list + coke.name + " ";
						break;
					case 2:
						count++;
						System.out.println(cider.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
						sum = sum + cider.price;
						list = list + cider.name + " ";
						break;
					case 3:
						count++;
						System.out.println(cokeZero.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
						sum = sum + cokeZero.price;
						list = list + cokeZero.name + " ";
						break;
					case 4:
						System.out.println("안녕히 가세요.");
						break kiosk;
					}
					}
					break;
					
					
			case 3:
				
				dessert: while(true) {
					System.out.println("디저트를 선택해주세요.");
					System.out.println("0.이전으로 1." + icecream.name + "(" + icecream.price + ") 2." + cottonCandy.name + "(" + cottonCandy.price + ") 3." + chocolate.name + "(" + chocolate.price + ") 4.종료");

					touch = sc.nextInt();
					switch(touch) {
					case 0: 
						break dessert;
					case 1:
						count++;
						System.out.println(icecream.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
						sum = sum + icecream.price;
						list = list + icecream.name + " ";
						break;
					case 2:
						count++;
						System.out.println(cottonCandy.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
						sum = sum + cottonCandy.price;
						list = list + cottonCandy.name + " ";
						break;
					case 3:
						count++;
						System.out.println(chocolate.name + "을(를) 추가했습니다. 현재 " + count + "개를 담았습니다.");
						sum = sum + chocolate.price;
						list = list + chocolate.name + " ";
						break;
					case 4:
						System.out.println("안녕히 가세요.");
						break kiosk;
					}
					}
					break;
			case 4:
				System.out.println("안녕히 가세요.");
				break kiosk;
				
			}
		}
		
		System.out.println("주문 내역: " + list);
		System.out.println("총 가격: " + sum + "원");
		

		sc.close();

	}

}
