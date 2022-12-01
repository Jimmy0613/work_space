package com.cre;

public class Move {
	int moveToDirection(Room currentRoom, String input) {
		int currentRoomId = currentRoom.id;
		switch (input) {
		case "1":
			if (currentRoom.e != 0) {
				currentRoomId = currentRoom.e;
				System.out.println("동쪽으로 이동했습니다.");
				break;
			}
		case "2":
			if (currentRoom.w != 0) {
				currentRoomId = currentRoom.w;
				System.out.println("서쪽으로 이동했습니다.");
				break;
			}
		case "3":
			if (currentRoom.s != 0) {
				currentRoomId = currentRoom.s;
				System.out.println("남쪽으로 이동했습니다.");
				break;
			}
		case "4":
			if (currentRoom.n != 0) {
				currentRoomId = currentRoom.n;
				System.out.println("북쪽으로 이동했습니다.");
				break;
			}
		case "5":
			if (currentRoom.u != 0) {
				currentRoomId = currentRoom.u;
				System.out.println("위쪽으로 이동했습니다.");
				break;
			}
		case "6":
			if (currentRoom.d != 0) {
				currentRoomId = currentRoom.d;
				System.out.println("아래쪽으로 이동했습니다.");
				break;
			}
		default:
			currentRoomId = currentRoom.e;
			System.out.println("그곳으로는 갈 수 없습니다.");
		}
		
		return currentRoomId;

	}

}
