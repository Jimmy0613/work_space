package com.cre;

import java.util.Scanner;

import com.cre.util.Util;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		new Character("‍제리", 100, 100, 50);
		Monster snail1 = new Monster("sn-001", "달팽이", 50, 50, 1001, 15, 35);
		Monster snail2 = new Monster("sn-002", "달팽이", 50, 50, 1001, 15, 35);
		Monster snail3 = new Monster("sn-003", "달팽이", 50, 50, 1001, 15, 35);
		Monster slime1 = new Monster("sl-001", "슬라임", 70, 70, 1002, 25, 45);
		Monster slime2 = new Monster("sl-002", "슬라임", 70, 70, 1002, 25, 45);

		Room start = new Room(1000, "입구", 1001, 0, 0, 0, 0, 0);
		start.roomDesc = "여기가 어디지? 동쪽으로 나가보자.";
		Room trRoomW = new Room(1001, "연습장 서쪽", 1002, 1000, 0, 0, 0, 0);
		trRoomW.roomDesc = "연습장 서쪽이다. 달팽이만 있다.";
		Room trRoom = new Room(1002, "연습장", 0, 1001, 0, 0, 0, 0);
		trRoom.roomDesc = "연습장이다. 슬라임이 돌아다닌다.";

		Monster[] monsterArray = { snail1, snail2, snail3, slime1, slime2 };
		Room[] roomArray = { start, trRoomW, trRoom }; // >--

		Util.pr("-- * -- 게임 시작 -- * --");
		Util.br();
		Util.controlInfo();

		int currentRoomId = 1000; // 현재 방 번호(시작은 고정)

		game: while (true) {

			RoomFunctions.displayRoomInfo(roomArray, monsterArray, currentRoomId);
			Character.displayCharacterInfo();
			input = sc.next();

			while (true) {
				switch (input) {
				case "x":
					Util.pr("게임 종료");
					Util.br();
					break game;
				case "0":
					if (Character.mode == "대기") {
						Util.prl("특별한 것은 보이지 않는다.");
						break;
					} else if (Character.mode == "전투") {
						Battle.getMonsterArray(monsterArray);
						Battle.battleOneByOne(currentRoomId);
						if (Battle.game == false) {
							break game;
						}

						RoomFunctions.displayRoomInfo(roomArray, monsterArray, currentRoomId);
						Character.info();
						break;
					}
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
					currentRoomId = Move.moveToDirection(currentRoomId, input);
				}
				input = sc.next();
			}
		}
		sc.close();
	}

}
