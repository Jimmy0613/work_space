package com.cre;

public class Turn {
	int count = 0;
	int turn(int count) {
		count++;
		return count;
	}
	void getInput(String input, int count) {
		if (input == "0") {
			count = count + 1;
			System.out.println("특별한 것은 보이지 않는다.");
		}
}
}
