package com.cre.board.c;

import com.cre.board.c.db.DataGetInfo;
import com.cre.board.c.util.display.Disp;

public class Page {
	public final static int PER_PAGE = 5;
	public static int currentPage = 1;
	public static int currentPageS = 1;
	public static int startIndex = 0;
	public static int startIndexS = 0;
	public static int lastPage;
	public static int lastPageS;
	DataGetInfo dgi = new DataGetInfo();

	public void getPages() { //자게 페이지
		int totalCnt = 0;
		totalCnt = dgi.getCount("board_post", "");
		if (totalCnt % PER_PAGE == 0) {
			lastPage = totalCnt / PER_PAGE;
		} else {
			lastPage = totalCnt / PER_PAGE + 1;
		}
	}

	public void getPagesInSearch(String key, String keyword) {
		int totalCnt = 0;											//like '%어쩌고%' 하면 어쩌고가 포함된 게 나옴.
		 	totalCnt = dgi.getCount("board_post", "where " + key + " like '%" + keyword + "%'");
			if (totalCnt == 0) {
				Disp.infoPrint("<!> 검색 결과가 없어요.");
				Board.input = "x";
				return;
			}
		 	if (totalCnt % PER_PAGE == 0) {
				lastPageS = totalCnt / PER_PAGE;
			} else {
				lastPageS = totalCnt / PER_PAGE + 1;
			}
	}

}
