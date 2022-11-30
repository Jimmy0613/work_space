package com.cre;

import java.util.Scanner;

public class Rps01 {

	public static void main(String[] args) {
		int com = (int)Math.floor(Math.random()*3) + 1;
		
		String comStr = null;
		switch(com) {
		case 1:
			comStr = "가위";
			break;
		case 2:
			comStr = "바위";
			break;
		case 3:
			comStr = "보";
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위, 바위, 보를 입력하세요.");
		String input = sc.next();
		System.out.println("나: " + input);
		System.out.println("컴: " + comStr);
		
		if(input.equals("가위")) {
			if(comStr.equals("바위")) {
				System.out.println("결과: 졌습니다!");
			} else if(comStr.equals("보")) {
				System.out.println("결과: 이겼습니다!");
			} else {
				System.out.println("결과: 비겼습니다!");
			}
		}
		if(input.equals("바위")) {
			if(comStr.equals("보")) {
				System.out.println("결과: 졌습니다!");
			} else if(comStr.equals("가위")) {
				System.out.println("결과: 이겼습니다!");
			} else {
				System.out.println("결과: 비겼습니다!");
			}
		}
		if(input.equals("보")) {
			if(comStr.equals("가위")) {
				System.out.println("결과: 졌습니다!");
			} else if(comStr.equals("바위")) {
				System.out.println("결과: 이겼습니다!");
			} else {
				System.out.println("결과: 비겼습니다!");
			}
		}
	}

}
