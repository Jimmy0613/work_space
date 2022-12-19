package com.cre.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cre.board.Board;
import com.cre.board.display.Disp;
import com.cre.util.Cw;

public class Database {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	
	public void dbBoard() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "0000");
			st = con.createStatement();

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public void dbList(int limit) {
		dbBoard();
		DataPage.dbPage();
		Disp.menuPrint(" [ 자유게시판 ] (n:쓰기 r:읽기 s:검색 x:이전으로)");
		Cw.dot();
		Cw.wn(Cw.sf(" 번호 ", 4) + Cw.sf("|  글쓴이", 10) + Cw.sf("| 제목 ", 40) + Cw.sf("| 조회수 ", 10));
		Cw.lineBar();
		try {
			result = st.executeQuery("select * from board_post order by post_num desc limit " + limit + ", 5");

			while (result.next()) {
				int postNum = result.getInt("post_num");
				String writer = result.getString("wr_id");
				String title = result.getString("title");
				int re_count = result.getInt("re_count");
				if (title.length() > 38) {
					title = title.substring(0, 20);
				}
				int hit = result.getInt("hit");
				Cw.dot();
				if (re_count == 0) {
					Cw.wn(Cw.sf(" " + postNum, 6) + Cw.sf(" " + writer, 10) + Cw.sf(title, 40) + Cw.sf(" " + hit, 10));
				} else {
					Cw.wn(Cw.sf(" " + postNum, 6) + Cw.sf(" " + writer, 10) + Cw.sf(title + " (" + re_count + ")", 40)
							+ Cw.sf(" " + hit, 10));
				}
				Cw.lineBar();
			}
		} catch (SQLException e) {
			Cw.wn("SQLException: " + e.getMessage());
			Cw.wn("SQLState: " + e.getSQLState());
		}
		DataPage.pageInfo(DataPage.page, DataPage.lastPage);

	}



	public void dbRead(int postNum) {
		dbBoard();
		DataUpdate du = new DataUpdate();
		du.dbHit(postNum);
		try {
			result = st.executeQuery("select * from board_post where post_num = " + postNum);
			if (result.next()) {
				do {
					String writer = result.getString("wr_id");
					String date = result.getString("date");
					String title = result.getString("title");
					String content = result.getString("content");
					int hit = result.getInt("hit");
					int re_count = result.getInt("re_count");
					Disp.menuPrint(Cw.sf("[" + postNum + "]", 4) + " 제목: " + title + " ");
					Cw.wn(Cw.sf("[글쓴이:" + writer, 12) + Cw.sf("|" + date, 15) + "]" + Cw.sf(" 조회수 " + hit, 10));
					Cw.wn();
					Cw.wn(" " + content);
					Cw.wn();
					Cw.lineBar();
					Cw.wn("[댓글 " + re_count + "개] r:쓰기");
					Cw.lineBar();
					dbReply(postNum);
					Cw.wn();
					Cw.wn(" [ 목록:x | 수정:e | 삭제:d ]");
					Cw.lineBar();
				} while (result.next());
				return;
			} else {
				Disp.menuPrint("<!> 없는 번호입니다.");
				Board.input = "x";
				return;
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}

	}

	public void dbReply(int postNum) {
		dbBoard();

		try {
			result = st.executeQuery("select * from board_reply where re_pNum = " + postNum);
			while (result.next()) {
				String writer = result.getString("re_writer");
				String content = result.getString("re_content");
				Cw.dot();
				Cw.wn(Cw.sf(" " + writer, 10) + Cw.sf(content, 40));
				Cw.lineBar();
			}
		} catch (SQLException e) {
			Cw.wn("SQLException: " + e.getMessage());
			Cw.wn("SQLState: " + e.getSQLState());
		}
	}

}
