package com.cre;

import java.util.Scanner;

public class Rps02 {

	public static void main(String[] args) {

		while (true) {

			Scanner sc = new Scanner(System.in);

			System.out.println("가위, 바위, 보를 입력하세요.(종료: 0)"); // 입력 받음 (0 입력시 종료)
			String input = sc.next();

			while (true) { // 예외 처리(가위, 바위, 보만 입력해야 진행 가능)

				if (input.equals("가위") || input.equals("바위") || input.equals("보")) {
					break;
				} else if (input.equals("0")) { 
					break;
				} else {
					System.out.println("가위, 바위, 보 중 하나를 입력해주세요.(종료: 0)"); //예외 처리 중에도 종료 가능
				}
				input = sc.next();

			}

			if (input.equals("0")) {
				System.out.println("종료합니다."); // 0 입력시 프로그램 종료
				break;
			}

			System.out.println("나: " + input);

			int com = (int) Math.floor(Math.random() * 3) + 1;

			String comStr = null;

			switch (com) {
			case 1:
				comStr = "가위";
				break;
			case 2:
				comStr = "바위";
				break;
			case 3:
				comStr = "보";
			}

			System.out.println("컴: " + comStr);

			switch (input) {
			
			case "가위":
				if (comStr.equals("바위")) {
					System.out.println("결과: 졌습니다!");
				} else if (comStr.equals("보")) {
					System.out.println("결과: 이겼습니다!");
				} else {
					System.out.println("결과: 비겼습니다!");
				}
				break;

			case "바위":
				if (comStr.equals("보")) {
					System.out.println("결과: 졌습니다!");
				} else if (comStr.equals("가위")) {
					System.out.println("결과: 이겼습니다!");
				} else {
					System.out.println("결과: 비겼습니다!");
				}
				break;

			case "보":
				if (comStr.equals("가위")) {
					System.out.println("결과: 졌습니다!");
				} else if (comStr.equals("바위")) {
					System.out.println("결과: 이겼습니다!");
				} else {
					System.out.println("결과: 비겼습니다!");
				}
				break;
			}

		}
	}
}
