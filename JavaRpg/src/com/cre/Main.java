package com.cre;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		int count = 0;
		// 필요한 것들 선언--<
		Character Tom = new Character("‍톰", 100, 100, 50);
		
		Monster snail = new Monster("sn-000", "달팽이", 50, 50, 1001);
		Monster slime = new Monster("sl-000", "슬라임", 70, 70, 1002);
		
		Room start = new Room(1000, "입구", 1001, 0, 0, 0, 0, 0);
		start.roomDesc = "여기가 어디지? 동쪽으로 나가보자.";
		Room trRoomW = new Room(1001, "연습장 서쪽", 1002, 1000, 0, 0, 0, 0);
		trRoomW.roomDesc = "연습장 서쪽이다. 달팽이만 있다.";
		Room trRoom = new Room(1002, "연습장", 0, 1001, 0, 0, 0, 0);
		trRoom.roomDesc = "연습장이다. 슬라임이 돌아다닌다.";
		
		Monster[] monsterArray = { snail, snail, snail, slime, slime };
		Room[] roomArray = { start, trRoomW, trRoom }; // >--
		
//		Monster[] currentRoomMonster; // 배틀 위한 몬스터 받을 배열
		RoomFunctions room = new RoomFunctions(); // RoomFunctions 도구
		Turn turn = new Turn(); // Turn 클래스 도구
		Move move = new Move(); // Move 클래스 도구
		Room[] currentRoom = new Room[1]; // 현재 위치만 담는 배열

		System.out.println("-- * -- 게임 시작 -- * --");

		int currentRoomId = 1000; // 현재 방 번호(시작은 고정)
//		String currentMode = "대기";
		
		game: while (true) {

			room.getRoomArray(roomArray);// RoomFunctions에 룸 어레이 넘겨줌
			room.getMonsterArray(monsterArray);
			currentRoom = room.getCurrentRoom(currentRoomId);
			room.getRoomMonster();
			System.out.println("[조작법]  0:턴진행/전투 1:동쪽 2:서쪽 3:남쪽 4:북쪽 5:위쪽 6:아래쪽 x:종료 (현재 턴:" + count + ")");
			Tom.info();
			room.info();

			input = sc.next();

			switch (input) {
			case "x":
				System.out.println("게임 종료");
				break game;
			case "0":
				turn.getInput(input, count);
				break;
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				currentRoomId = move.moveToDirection(currentRoom[0], input);
				count = turn.turn(count);
				
			}
		}
	}

}
