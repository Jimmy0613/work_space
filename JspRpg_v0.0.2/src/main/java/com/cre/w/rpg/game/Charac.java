package com.cre.w.rpg.game;

import com.cre.w.rpg.db.DataSelect;
import com.cre.w.rpg.db.DataUpdate;
import com.cre.w.rpg.db.Member;

public class Charac {
	DataSelect ds = new DataSelect();
	DataUpdate du = new DataUpdate();
	public static String info = "";
	public static String name = "";
	public static int level = 0;
	public static int power = 0;
	public static int powerFull = 0;
	public static int coin = 0;
	public static int exp = 0;
	public static int max_exp = 0;
	public static int story = 0;
	public static int location = 0;
	public static int map = 0;
	public void loadCharacter() {
		String where = "where c_num = " + Member.playerC;
		name = ds.dbExecuteQueryStr("c_name", "characters", where);
		level = ds.dbExecuteQueryInt("lev", "characters", where);
		power = ds.dbExecuteQueryInt("power", "characters", where);
		powerFull = ds.dbExecuteQueryInt("power_full", "characters", where);
		coin = ds.dbExecuteQueryInt("coin", "characters", where);
		exp = ds.dbExecuteQueryInt("exp", "characters", where);
		max_exp = ds.dbExecuteQueryInt("max_exp", "characters", where);
		story = ds.dbExecuteQueryInt("story", "characters", where);
		location = ds.dbExecuteQueryInt("location", "characters", where);
		map = ds.dbExecuteQueryInt("map", "characters", where);
		info = "[ " + name + " ] ✨레벨(" + level + ") 💪힘(" + power + "/" + powerFull + ") 💰코인(" + coin + ")";
	}
	
	public void updateCharacter() {
		String query = "update characters set lev = " + Charac.level + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
		query = "update characters set power = " + Charac.power + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
		query = "update characters set power_full = " + Charac.powerFull + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
		query = "update characters set exp = " + Charac.exp + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
		query = "update characters set max_exp = " + Charac.max_exp + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
		query = "update characters set location = " + Map.m_id + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
		query = "update characters set story = " + Charac.story + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
		query = "update characters set coin = " + Charac.coin + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
		query = "update characters set map = " + Charac.map + " where c_num = " + Member.playerC;
		du.dbExecuteUpdate(query);
	}
	
}
