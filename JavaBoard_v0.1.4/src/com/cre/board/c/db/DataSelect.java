package com.cre.board.c.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataSelect { //executeSelect로 하는거 (글, 댓글, 목록 불러오는거) 모음
	Connection con = null; //db 커넥터
	Statement st = null; //db statement
	ResultSet result = null; //resultSet 사실 먼지 잘 모름 일단 이거 세개 있어야 함

	//**여러 줄 필요할때(ex.목록, 댓글) 씀. str 버전. int도 이거랑 똑같음. sql에서 해당 칼럼의 자료형에 따라 쓰면 됨.
	//매개변수 obj = 내가 가져올 칼럼명, table =가져올 테이블
	//where=where절(조건). 꼭 where로 시작 안해도 그냥 넣으면 됨.. ex.order by, limit 등등..
	public ArrayList<String> dbExecuteQueryStrArr(String obj, String table, String where) {
		//결과 담을것. **칼럼별임. 줄별 아님! (post_num만/제목만/내용만 이런식)
		ArrayList<String> r = new ArrayList<>(); 
		try {
			//이렇게 매번 연결하고 끊기 할거임.. 게시판을 복잡하게 만들수록 too many connection이라고 뜨면서 안되기 시작함.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "0000");
			st = con.createStatement();
			result = st.executeQuery("select * from " + table + " " + where); //이걸 이해하는게 중요함
			while (result.next()) {
				String s = result.getString(obj); //모두 가져와서 obj만 쏙 빼가기. 
				r.add(s); //어레이리스트에 순서대로 차곡차곡 담음.
			}
			con.close(); //연결 끊음. 과도한 커넥션 방지..
		} catch (SQLException e) { 
		}
		return r;
	}
	
	//**딱 한줄만 가져올 때(ex.게시글 정보) 씀.. 어레이리스트로 리턴 안하고 그냥 String 변수 한개로 리턴. 나머진 같음
	public String dbExecuteQueryStr(String obj, String table, String where) {
		String r = "";
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "0000");
			st = con.createStatement();
			result = st.executeQuery("select * from " + table + " " + where);
			while (result.next()) {
				r = result.getString(obj);
			}
			con.close();
		} catch (SQLException e) {
		}
		return r;
	}

	public ArrayList<Integer> dbExecuteQueryIntArr(String obj, String table, String where) {
		ArrayList<Integer> r = new ArrayList<>();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "0000");
			st = con.createStatement();
			result = st.executeQuery("select " + obj + " from " + table + " " + where);
			while (result.next()) {
				int s = result.getInt(obj);
				r.add(s);
			}
			con.close();
		} catch (SQLException e) {
		}
		return r;
	}

	public int dbExecuteQueryInt(String obj, String table, String where) {
		int r = -1;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "0000");
			st = con.createStatement();
			result = st.executeQuery("select " + obj + " from " + table + " " + where);
			while (result.next()) {
				r = result.getInt(obj);
			}
			con.close();
		} catch (SQLException e) {
		}
		return r;
	}

	
}
