package com.cre.board.db;

import java.sql.SQLException;

import com.cre.board.display.Disp;
import com.cre.util.Cw;

public class DataSearch {
	Database db = new Database();
	DataPage dp = new DataPage();
	
	public void dbSearch(String key, String keyword, int limit) {
		db.dbBoard();
		dp.dbSearchPage(key, keyword);
		Disp.menuPrint(" [ 검색 ] (r:읽기 x:이전)");
		Cw.dot();
		Cw.wn(Cw.sf(" 번호 ", 4) + Cw.sf("|  글쓴이", 10) + Cw.sf("| 제목 ", 40) + Cw.sf("| 조회수 ", 10));
		Cw.lineBar();
		if (dp.totalCntS == 0) {
			Disp.menuPrint("<!> 검색 결과가 없어요.");
			return;
		}
		try {
			db.result = db.st.executeQuery("select * from board_post where " + key + " like '%" + keyword + "%' limit " + limit + ", 5");

			while (db.result.next()) {
				int postNum = db.result.getInt("post_num");
				String writer = db.result.getString("wr_id");
				String title = db.result.getString("title");
				int re_count = db.result.getInt("re_count");
				if (title.length() > 38) {
					title = title.substring(0, 20);
				}
				int hit = db.result.getInt("hit");
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
		DataPage.pageInfo(DataPage.pageS, DataPage.lastPageS);

	}
}
