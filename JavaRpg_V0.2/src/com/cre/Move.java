package com.cre;

import com.cre.util.Util;

public class Move {
	static int moveToDirection(int currentRoomId, String input) {
		switch (input) {
		case "1":
			if (RoomFunctions.getEastRoomId(currentRoomId) != 0) {
				currentRoomId = RoomFunctions.getEastRoomId(currentRoomId);
				Util.prl("<시스템> 동쪽으로 이동했습니다.");
				RoomFunctions.displayRoomInfo(RoomFunctions.roomArr, RoomFunctions.monsterArr, currentRoomId);
				RoomFunctions.getRoomMonsters(currentRoomId);
				Character.info();
				Turn.turn++;
				Util.br();
			} else {
				Util.prl("<시스템> <!> 그곳으로는 갈 수 없습니다.");
				Util.br();
			}
			return currentRoomId;
		case "2":
			if (RoomFunctions.getWestRoomId(currentRoomId) != 0) {
				currentRoomId = RoomFunctions.getWestRoomId(currentRoomId);
				Util.prl("<시스템> 서쪽으로 이동했습니다.");
				RoomFunctions.displayRoomInfo(RoomFunctions.roomArr, RoomFunctions.monsterArr, currentRoomId);
				RoomFunctions.getRoomMonsters(currentRoomId);
				Character.info();
				Turn.turn++;
				Util.br();
			} else {
				Util.prl("<시스템> <!> 그곳으로는 갈 수 없습니다.");
				Util.br();
			}
			return currentRoomId;
		case "3":
			if (RoomFunctions.getSouthRoomId(currentRoomId) != 0) {
				currentRoomId = RoomFunctions.getSouthRoomId(currentRoomId);
				Util.prl("<시스템> 남쪽으로 이동했습니다.");
				RoomFunctions.displayRoomInfo(RoomFunctions.roomArr, RoomFunctions.monsterArr, currentRoomId);
				RoomFunctions.getRoomMonsters(currentRoomId);
				Character.info();
				Turn.turn++;
				Util.br();
			} else {
				Util.prl("<시스템> <!> 그곳으로는 갈 수 없습니다.");
				Util.br();
			}
			return currentRoomId;
		case "4":
			if (RoomFunctions.getNorthRoomId(currentRoomId) != 0) {
				currentRoomId = RoomFunctions.getNorthRoomId(currentRoomId);
				Util.prl("<시스템> 북쪽으로 이동했습니다.");
				RoomFunctions.displayRoomInfo(RoomFunctions.roomArr, RoomFunctions.monsterArr, currentRoomId);
				RoomFunctions.getRoomMonsters(currentRoomId);
				Character.info();
				Turn.turn++;
				Util.br();
			} else {
				Util.prl("<시스템> <!> 그곳으로는 갈 수 없습니다.");
				Util.br();
			}
			return currentRoomId;
		case "5":
			if (RoomFunctions.getUpRoomId(currentRoomId) != 0) {
				currentRoomId = RoomFunctions.getUpRoomId(currentRoomId);
				Util.prl("<시스템> 위쪽으로 이동했습니다.");
				RoomFunctions.displayRoomInfo(RoomFunctions.roomArr, RoomFunctions.monsterArr, currentRoomId);
				RoomFunctions.getRoomMonsters(currentRoomId);
				Character.info();
				Turn.turn++;
				Util.br();
			} else {
				Util.prl("<시스템> <!> 그곳으로는 갈 수 없습니다.");
				Util.br();
			}
			return currentRoomId;
		case "6":
			if (RoomFunctions.getDownRoomId(currentRoomId) != 0) {
				currentRoomId = RoomFunctions.getDownRoomId(currentRoomId);
				Util.prl("<시스템> 아래쪽으로 이동했습니다.");
				RoomFunctions.displayRoomInfo(RoomFunctions.roomArr, RoomFunctions.monsterArr, currentRoomId);
				RoomFunctions.getRoomMonsters(currentRoomId);
				Character.info();
				Turn.turn++;
				Util.br();
			} else {
				Util.prl("<시스템> <!> 그곳으로는 갈 수 없습니다.");
				Util.br();
			}
			return currentRoomId;
		default:
			return currentRoomId;
		}
	}
}
