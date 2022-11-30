package com.cre;

import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		int[] com = new int[6];
		while (true) {
		    com[1] = (int) (Math.floor(Math.random() * 45) + 1);
		    if (com[1] != com[0]) {
		        break;
		    }
		}
		while (true) {
		    com[2] = (int) (Math.floor(Math.random() * 45) + 1);
		    if (com[2] != com[0] && com[2] != com[1]) {
		        break;
		    }
		}
		while (true) {
		    com[3] = (int) (Math.floor(Math.random() * 45) + 1);
		    if (com[3] != com[0] && com[3] != com[1] && com[3] != com[2]) {
		        break;
		    }
		}
		while (true) {
		    com[4] = (int) (Math.floor(Math.random() * 45) + 1);
		    if (com[4] != com[0] && com[4] != com[1] && com[4] != com[2] && com[4] != com[3]) {
		        break;
		    }
		}
		while (true) {
		    com[5] = (int) (Math.floor(Math.random() * 45) + 1);
		    if (com[5] != com[0] && com[5] != com[1] && com[5] != com[2] && com[5] != com[3] && com[5] != com[4]) {
		        break;
		    }
		}
		int bonus;
		while (true) {
		    bonus = (int) (Math.floor(Math.random() * 45) + 1);
		    if (bonus != com[0] && bonus != com[1] && bonus != com[2] && bonus != com[3] && bonus != com[4] && bonus != com[5]) {
		        break;
		    }
		}
		
		Scanner sc = new Scanner(System.in);
		int[] input = new int[6];
		
		for(int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		
		System.out.println("당첨 숫자: ");
		for(int m : com) {
			System.out.println(m);
		}
		System.out.println();
		
		System.out.println("내 숫자: ");
		for(int m : input) {
			System.out.println(m);
		}
		System.out.println();
		int count = 0;
		for (int i = 0; i<input.length; i++) {
			for (int j = 0; j<com.length; j++) {
				if(input[i]==com[j])
					count++;
			}
		}
		switch(count) {
		case 0:
		case 1:
		case 2:
			System.out.println("꽝입니다.");
			break;
		case 3:
			System.out.println("5등입니다.");
			break;
		case 4:
			System.out.println("4등입니다.");
			break;
		case 6:
			System.out.println("1등입니다.");
			break;
		case 5:
			for (int i = 0; i<input.length; i++) {
				if (input[i]==bonus) {
					System.out.println("2등입니다.");
					break;
				}
			}
		default: System.out.println("3등입니다.");

		}
		
		
		
}
}