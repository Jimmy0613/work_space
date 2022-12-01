package com.cre;

public class RoomFunctions {
	Room[] roomArr;
	Monster[] monsterArr;
	Room[] currentRoom = new Room[1];
	int currentRoomId = 0;
	
	Room[] getRoomArray(Room[] roomArray) {
		this.roomArr = roomArray;
		return this.roomArr;
	}
	Monster[] getMonsterArray(Monster[] monsterArray) {
		this.monsterArr = monsterArray;
		return this.monsterArr;
	}
	
	Room[] getCurrentRoom(int currentRoomId) {
		this.currentRoomId = currentRoomId;
		for (int i = 0; i<this.roomArr.length; i++) {
			if (this.roomArr[i].id == currentRoomId) {
				this.currentRoom[0] = this.roomArr[i];
			}
		}
		return this.currentRoom;
	}
	String roomMonster;
	String getRoomMonster() {
		this.roomMonster = "";
		for(int i = 0; i<this.monsterArr.length; i++) {
			if(this.monsterArr[i].location == this.currentRoom[0].id) {
				this.roomMonster = this.roomMonster + this.monsterArr[i].name + "[" + this.monsterArr[i].hp + "/" + this.monsterArr[i].maxHp + "] ";
			}
		} 
		if (this.roomMonster != "") {
			this.roomMonster = this.roomMonster + " (전투:0)";
		}
		return this.roomMonster;
	}
	
	void info() {
		System.out.print("[몬스터]  ");
				System.out.print(this.roomMonster);
		
		System.out.println();
		System.out.println("[현위치]  [" + this.currentRoom[0].name + "] " + this.currentRoom[0].roomDesc + this.currentRoom[0].wayOutStr + ")");
	}
}

