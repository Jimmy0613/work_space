package com.cre.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cre.board.ProcMenu;
import com.cre.board.display.Disp;
import com.cre.util.Cw;

public class Database {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;

	public void dbPost() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "0000");
			st = con.createStatement();

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void dbRead(int postNum) {
		dbHit(postNum);
		try {
			result = st.executeQuery("select * from board_post where post_num = " + postNum);
			if (result.next()) {
				do {
					String writer = result.getString("wr_id");
					String date = result.getString("date");
					String title = result.getString("title");
					String content = result.getString("content");
					int hit = result.getInt("hit");
					Disp.menuPrint(Cw.sf("[" + postNum + "]", 4) + " 제목: " + title + " ");
					Cw.wn(Cw.sf("[작성자:" + writer, 12) + Cw.sf("|" + date, 15) + "]" + Cw.sf(" 조회수 " + hit, 10));
					Cw.wn();
					Cw.wn(" " + content);
					Cw.wn();
					Cw.lineBar();
					Cw.wn("[댓글] (" + 0 + "개의 댓글이 있습니다.) r:댓글쓰기");
					Cw.lineBar();
					Cw.wn();
					Cw.wn(" [ 이전글:1 | 목록:2 | 다음글:3 ] [수정:4][삭제:5]");
					Cw.lineBar();
				} while (result.next());
			} else {
				Cw.wn("없는 번호입니다.");
				ProcMenu.input = "x";
				return;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}

	}

	public void dbList() {
		dbPost();
		try {
			result = st.executeQuery("select * from board_post");

			while (result.next()) {
				int postNum = result.getInt("post_num");
				String writer = result.getString("wr_id");
				String title = result.getString("title");
				if(title.length()>38) {
				title = title.substring(0,20);
				}
				int hit = result.getInt("hit");
				Cw.dot();
				Cw.wn(Cw.sf(" " + postNum, 6) + Cw.sf(" " + writer, 10) + Cw.sf(title, 40) + Cw.sf(" " + hit, 10));
				Cw.lineBar();
			}
		} catch (SQLException e) {
			Cw.wn("SQLException: " + e.getMessage());
			Cw.wn("SQLState: " + e.getSQLState());
		}

	}

	public void dbDel(int postNum) {
		dbPost();
		try {
			st.executeUpdate("delete from board_post where post_num =" + postNum);

		} catch (SQLException e) {
			Cw.wn("SQLException: " + e.getMessage());
			Cw.wn("SQLState: " + e.getSQLState());
		}
	}

	public void dbWrite(String query) {
		dbPost();
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dbEdit(String query) {
		dbPost();
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbHit(int postNum) {
		dbPost();
		try {
			st.executeUpdate("update board_post set hit = hit + 1 where post_num =" + postNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
