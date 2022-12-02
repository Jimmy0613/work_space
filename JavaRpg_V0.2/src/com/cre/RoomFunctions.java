package com.cre;

import java.util.ArrayList;

import com.cre.util.Util;

public class RoomFunctions {
	static Room[] roomArr;
	static Monster[] monsterArr;
	static Room[] currentRoom = new Room[1];

	static Room[] getRoomArray(Room[] roomArray) {
		roomArr = roomArray;
		return roomArr;
	}

	static Monster[] getMonsterArray(Monster[] monsterArray) {
		monsterArr = monsterArray;
		return monsterArr;
	}

	static ArrayList<Monster> roomMonsters = new ArrayList<Monster>();
	static ArrayList<Monster> getRoomMonsters(int currentRoomId) {
		roomMonsters.clear();
		for (int i = 0; i < monsterArr.length; i++) {
			if (monsterArr[i] != null) {

				if (monsterArr[i].location == currentRoomId) {
					roomMonsters.add(monsterArr[i]);
				}
			}
		}
		return roomMonsters;
	}

	static String roomMonsterInfo;

	static String getRoomMonsterInfo(int currentRoomId) {
		roomMonsterInfo = "";
		for (int i = 0; i < monsterArr.length; i++) {
			if (monsterArr[i] != null) {
				if (monsterArr[i].location == currentRoomId) {
					roomMonsterInfo = roomMonsterInfo + monsterArr[i].info() + " ";
				}
			}
		}
		if (roomMonsterInfo != "") {
			roomMonsterInfo = roomMonsterInfo + "(전투하기(0))";
		}
		
		return roomMonsterInfo;
	}

	static String getCurrentRoomInfo(int currentRoomId) {
		String currentRoomInfo = "";
		for (int i = 0; i < roomArr.length; i++) {
			if (roomArr[i].id == currentRoomId) {
				currentRoomInfo = roomArr[i].roomInfo();
			}
		}
		return currentRoomInfo;
	}

	public static void displayRoomInfo(Room[] roomArray, Monster[] monsterArray, int currentRoomId) {
		RoomFunctions.getRoomArray(roomArray);// RoomFunctions에 룸 어레이 넘겨줌
		RoomFunctions.getMonsterArray(monsterArray);
		RoomFunctions.getRoomMonsters(currentRoomId);
		RoomFunctions.getRoomMonsterInfo(currentRoomId);
		Util.prl(RoomFunctions.getCurrentRoomInfo(currentRoomId));
		Util.pr("[몬스터]  ");
		Util.pr(roomMonsterInfo);
		Util.br();
		Character.mode = RoomFunctions.changeMode(roomMonsterInfo, Character.mode);
	}

	public static String changeMode(String roomMonster, String currentMode) {
		if (roomMonster != "") {
			currentMode = "전투";
		} else {
			currentMode = "대기";
		}
		return currentMode;
	}

	public static int getEastRoomId(int currentRoomId) {
		int currentRoomE = 0;
		for (int i = 0; i < roomArr.length; i++) {
			if (roomArr[i].id == currentRoomId) {
				currentRoomE = roomArr[i].e;
			}
		}
		return currentRoomE;
	}

	public static int getWestRoomId(int currentRoomId) {
		int currentRoomW = 0;
		for (int i = 0; i < roomArr.length; i++) {
			if (roomArr[i].id == currentRoomId) {
				currentRoomW = roomArr[i].w;
			}
		}
		return currentRoomW;
	}

	public static int getSouthRoomId(int currentRoomId) {
		int currentRoomS = 0;
		for (int i = 0; i < roomArr.length; i++) {
			if (roomArr[i].id == currentRoomId) {
				currentRoomS = roomArr[i].s;
			}
		}
		return currentRoomS;
	}

	public static int getNorthRoomId(int currentRoomId) {
		int currentRoomN = 0;
		for (int i = 0; i < roomArr.length; i++) {
			if (roomArr[i].id == currentRoomId) {
				currentRoomN = roomArr[i].n;
			}
		}
		return currentRoomN;
	}

	public static int getUpRoomId(int currentRoomId) {
		int currentRoomU = 0;
		for (int i = 0; i < roomArr.length; i++) {
			if (roomArr[i].id == currentRoomId) {
				currentRoomU = roomArr[i].u;
			}
		}
		return currentRoomU;
	}

	public static int getDownRoomId(int currentRoomId) {
		int currentRoomD = 0;
		for (int i = 0; i < roomArr.length; i++) {
			if (roomArr[i].id == currentRoomId) {
				currentRoomD = roomArr[i].d;
			}
		}
		return currentRoomD;
	}

}
