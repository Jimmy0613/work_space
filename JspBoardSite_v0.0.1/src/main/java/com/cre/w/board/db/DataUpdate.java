package com.cre.w.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataUpdate {
	public static String loginId = "";
	public static String loginGrade = "";
	public static String loginNickname = "";

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public void dbExecuteUpdate(String query) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jboard", "root", "0000");
			st = con.createStatement();
			st.executeUpdate(query);
			con.close();
		} catch (Exception e) {
		}
	}

	public void joinMember(String id, String pw, String nickname) {
		String query = "insert into members(id, pw, nickname) values('" + id + "', '" + pw + "', '" + nickname + "')";
		dbExecuteUpdate(query);
	}

	public String loginInfo() {
		String loginInfo = "[ 🍒 회원정보 🍒 ]";
		if (loginId.equals("")) {
			loginInfo += " 로그인해주세요.";
		} else {
			loginInfo += " " + loginNickname + "(" + loginId + ")님 (등급: " + loginGrade + ")";
		}
		return loginInfo;
	}
	
	public void updateHit(String postNum) {
		String query;
		query = "update board_p set hit = hit + 1 where p_num =" + postNum;
		dbExecuteUpdate(query);
	}
}
