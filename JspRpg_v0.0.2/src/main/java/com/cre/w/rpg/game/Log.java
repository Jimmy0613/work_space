package com.cre.w.rpg.game;

import java.util.ArrayList;

import com.cre.w.rpg.db.DataSelect;
import com.cre.w.rpg.db.DataUpdate;

public class Log {
	DataUpdate du = new DataUpdate();
	DataSelect ds = new DataSelect();
	public static int turnCount = 0;
	
	public void loadLog() {
		du.dbExecuteUpdate("drop table log;");
		du.dbExecuteUpdate("create table log (sm_num int primary key auto_increment, msg char(255));");
		turnCount=0;
	}
	public ArrayList<String> getLogTen() {
		ArrayList<String> msgs = new ArrayList<>();
		String where = "order by sm_num desc limit 0, 10";
		msgs = ds.dbExecuteQueryStrArr("msg", "log", where);
		return msgs;
	}
	public ArrayList<String> getLogAll() {
		ArrayList<String> msgs = new ArrayList<>();
		msgs = ds.dbExecuteQueryStrArr("msg", "log", "");
		return msgs;
	}
	
	public void turn() {
		turnCount++;
	}
}
