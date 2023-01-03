package com.cre.w.rpg.db;

public class Member {
	DataUpdate du = new DataUpdate();
	DataSelect ds = new DataSelect();
	public static String loginId = "";
	public static String loginName = "";
	public static int loginC1 = 0;
	public static int loginC2 = 0;
	public static int playerC = 0;
	
	//로그인 정보
	public String loginInfo() {
		String loginInfo = "[ 나 ]";
		if (loginId.equals("")) {
			loginInfo += " 먼저 로그인해주세요.";
		} else {
			loginInfo += " " + loginId + "(" + loginName + ")님";
		}
		return loginInfo;
	}
	
	//캐릭터가 있는지
	public boolean isChar(String c) {
		boolean ch = false;
		String where = "where id = '" + loginId + "'"; 
		int c_num = ds.dbExecuteQueryInt("count("+c+")", "members", where);
		if(c_num != 0) {
			ch = true;
		}
		return ch;
	}
	
	//캐릭터 이름/나이
	public String charProfile(String c) {
		String charInfo = "";
		String icon = "";
		String where = "where id = '" + loginId + "'"; 
		int c_num = ds.dbExecuteQueryInt(c, "members", where);
		where = "where c_num = " + c_num;
		String c_name = ds.dbExecuteQueryStr("c_name", "characters", where);
		int level = ds.dbExecuteQueryInt("lev", "characters", where);
		if(level < 5) {
			icon = "🐣";
		} else if(level<10) {
			icon = "🐥";
		} else {
			icon = "🦅";
		}
		charInfo += icon + " " + c_name + " ( 레벨: " + level + " )";
		return charInfo;
	}
	

}