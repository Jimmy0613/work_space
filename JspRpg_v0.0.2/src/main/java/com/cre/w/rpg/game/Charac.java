package com.cre.w.rpg.game;

import com.cre.w.rpg.db.DataSelect;
import com.cre.w.rpg.db.DataUpdate;
import com.cre.w.rpg.db.Member;

public class Charac {
	DataSelect ds = new DataSelect();
	DataUpdate du = new DataUpdate();
	public static String info = "";
	public static String name = "";
	public static int age = 0;
	public static int power = 0;
	public static int coin = 0;
	public static int exp = 0;
	public static int max_exp = 0;
	public static int turnCount = 0;
	
	public void loadCharacter() {
		String where = "where c_num = " + Member.playerC;
		name = ds.dbExecuteQueryStr("c_name", "characters", where);
		age = ds.dbExecuteQueryInt("c_age", "characters", where);
		power = ds.dbExecuteQueryInt("power", "characters", where);
		coin = ds.dbExecuteQueryInt("coin", "characters", where);
		exp = ds.dbExecuteQueryInt("exp", "characters", where);
		max_exp = ds.dbExecuteQueryInt("max_exp", "characters", where);
		info = "[ 캐릭터 ] " + name + " 💪힘(" + power + ") 💰코인(" + coin + ")";
	}
	
	public void updateCharacter(String obj, int var) {
		String query = "update characters set " + obj + "= '" + "' where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
	}
	
}
