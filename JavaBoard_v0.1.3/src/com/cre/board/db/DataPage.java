package com.cre.board.db;

import java.sql.SQLException;

import com.cre.util.Cw;

public class DataPage {
	public final static int PER_PAGE = 5;
	public static int totalCnt = 0;
	public int totalCntS = 0;
	public static int page = 1;
	public static int pageS = 1;
	public static int limit = 0;
	public static int limitS = 0;
	public static int lastPage;
	public static int lastPageS;
	static Database db = new Database();

	public static void dbPage() {
		db.dbBoard();
		try {
			db.result = db.st.executeQuery("select count(*) as total_cnt from board_post");
			if (db.result.next()) {
				totalCnt = db.result.getInt("total_cnt");
			}
			if (totalCnt % PER_PAGE == 0) {
				lastPage = totalCnt / PER_PAGE;
			} else {
				lastPage = totalCnt / PER_PAGE + 1;
			}
		} catch (SQLException e) {
			Cw.wn("SQLException: " + e.getMessage());
			Cw.wn("SQLState: " + e.getSQLState());
		}
	}
	
	public void dbSearchPage(String key, String keyword) {
		db.dbBoard();
		try {
			db.result = db.st.executeQuery("select count(*) as total_cnt from board_post where " + key + " like '%" + keyword + "%'");
			
			if (db.result.next()) {
				totalCntS = db.result.getInt("total_cnt");
			}
			if (totalCntS % PER_PAGE == 0) {
				lastPageS = totalCntS / PER_PAGE;
			} else {
				lastPageS = totalCntS / PER_PAGE + 1;
			}
		} catch (SQLException e) {
			Cw.wn("SQLException: " + e.getMessage());
			Cw.wn("SQLState: " + e.getSQLState());
		}
	}
	
	public static void pageInfo(int page, int lastPage) {
		Cw.w("[현재:" + page + "]");
		if (page <= 3) {
			for (int i = 1; i <= PER_PAGE && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" < " + i + " >");
				} else {
					Cw.w(" " + i);
				}
			}
			Cw.w(" ..");
		} else if(page >= lastPage - 2) {
			Cw.w(" ..");
			for (int i = lastPage - 4; i <= page + 2 && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" <" + i + ">");
				} else {
					Cw.w(" " + i);
				}
			}
		} else {
			Cw.w(" ..");
			for (int i = page - 2; i <= page + 2 && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" < " + i + " >");
				} else {
					Cw.w(" " + i);
				}
			}
			Cw.w(" ..");
		}
		Cw.wn(" [마지막:" + lastPage + "] [이전:c 다음:v 선택:p]");
		Cw.wn();
	}
}
