package com.cre.w.rpg.game;

import java.util.ArrayList;

public class System {
	public static ArrayList<String> message;
	public static int turnCount = 0;
	
	public void sendMsg(String msg) {
		message.add(msg);
	}
}
