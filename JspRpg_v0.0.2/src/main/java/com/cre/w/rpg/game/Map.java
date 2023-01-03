package com.cre.w.rpg.game;

import com.cre.w.rpg.db.DataSelect;
import com.cre.w.rpg.db.DataUpdate;

public class Map {
	public static int m_id = 0;
	public static String m_name = "";
	public static String m_desc = "";
	public static int east_map = 0;
	public static int west_map = 0;
	public static int south_map = 0;
	public static int north_map = 0;
	DataUpdate du = new DataUpdate();
	DataSelect ds = new DataSelect();
	Log l = new Log();
	
	public void loadMap() {
		String where = "where m_id = " + m_id;
		m_name = ds.dbExecuteQueryStr("m_name", "map", where);
		m_desc = ds.dbExecuteQueryStr("m_desc", "map", where);
		east_map = ds.dbExecuteQueryInt("e", "map", where);
		west_map = ds.dbExecuteQueryInt("w", "map", where);
		south_map = ds.dbExecuteQueryInt("s", "map", where);
		north_map = ds.dbExecuteQueryInt("n", "map", where);
	}

	public String getInfo() {
		String where = "where m_id = " + m_id;
		String name = ds.dbExecuteQueryStr("m_name", "map", where);
		String desc = ds.dbExecuteQueryStr("m_desc", "map", where);
		String info = "[ " + name + " ] " + desc;
		return info;
	}
	
	public String getName(int m_id) {
		String where = "where m_id = " + m_id;
		String name = ds.dbExecuteQueryStr("m_name", "map", where);
		String info = "[ " + name + " ] ";
		return info;
	}
	
	public void move() {
		l.turn();
		du.sendSystemMsg("[ " + Log.turnCount + " ] " + m_name + "(으)로 이동했습니다.");
		Charac.location = m_id;
	}
	
	

}
