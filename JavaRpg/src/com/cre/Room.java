package com.cre;

public class Room {
	int id = 0;
	String name = "";
	String roomDesc = "";
	int e = 0;
	int w = 0;
	int s = 0;
	int n = 0;
	int u = 0;
	int d = 0;
	String wayOutStr = ""; // 출구 표시 문자열

	Room(int id, String name, int e, int w, int s, int n, int u, int d) {
		this.id = id;
		this.name = name;
		this.e = e;
		this.w = w;
		this.s = s;
		this.n = n;
		this.u = u;
		this.d = d;
		this.roomEnter();
	}

	String roomEnter() {
		this.wayOutStr = " (출구:";
		if (this.e != 0) {
			wayOutStr += " 동쪽 ";
		}
		if (this.w != 0) {
			wayOutStr += " 서쪽 ";
		}
		if (this.s != 0) {
			wayOutStr += " 남쪽 ";
		}
		if (this.n != 0) {
			wayOutStr += " 북쪽 ";
		}
		if (this.u != 0) {
			wayOutStr += " 위쪽 ";
		}
		if (this.d != 0) {
			wayOutStr += " 아래쪽 ";
		}
		return this.wayOutStr;
	}

	
	
	}




