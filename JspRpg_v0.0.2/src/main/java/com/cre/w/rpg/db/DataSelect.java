package com.cre.w.rpg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataSelect {
	Connection con = null; //db 커넥터
	Statement st = null; //db statement
	ResultSet result = null; //resultSet 사실 먼지 잘 모름 일단 이거 세개 있어야 함

	public ArrayList<String> dbExecuteQueryStrArr(String obj, String table, String where) {
		ArrayList<String> r = new ArrayList<>(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "root", "0000");
			st = con.createStatement();
			result = st.executeQuery("select * from " + table + " " + where); //이걸 이해하는게 중요함
			while (result.next()) {
				String s = result.getString(obj); //모두 가져와서 obj만 쏙 빼가기. 
				r.add(s); //어레이리스트에 순서대로 차곡차곡 담음.
			}
			con.close(); //연결 끊음. 과도한 커넥션 방지..
		} catch (Exception e) { 
		}
		return r;
	}
	
	//**딱 한줄만 가져올 때(ex.게시글 정보) 씀.. 어레이리스트로 리턴 안하고 그냥 String 변수 한개로 리턴. 나머진 같음
	public String dbExecuteQueryStr(String obj, String table, String where) {
		String r = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "root", "0000");
			st = con.createStatement();
			result = st.executeQuery("select * from " + table + " " + where);
			while (result.next()) {
				r = result.getString(obj);
			}
			con.close();
		} catch (Exception e) {
		}
		return r;
	}

	public ArrayList<Integer> dbExecuteQueryIntArr(String obj, String table, String where) {
		ArrayList<Integer> r = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "root", "0000");
			st = con.createStatement();
			result = st.executeQuery("select " + obj + " from " + table + " " + where);
			while (result.next()) {
				int s = result.getInt(obj);
				r.add(s);
			}
			con.close();
		} catch (Exception e) {
		}
		return r;
	}

	public int dbExecuteQueryInt(String obj, String table, String where) {
		int r = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "root", "0000");
			st = con.createStatement();
			result = st.executeQuery("select " + obj + " from " + table + " " + where);
			while (result.next()) {
				r = result.getInt(obj);
			}
			con.close();
		} catch (Exception e) {
		}
		return r;
	}
}
