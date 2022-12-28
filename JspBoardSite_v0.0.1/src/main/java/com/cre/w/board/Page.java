package com.cre.w.board;

import com.cre.w.board.db.DataGetInfo;

public class Page {
	public final static int PER_PAGE = 5;
	public static int lastPageG;
	public static int startIndex = 0;
	public static int currentPage = 1;
	DataGetInfo dgi = new DataGetInfo();
	public void getPages() { //자게 페이지
		int totalCnt = 0;
		totalCnt = dgi.getCount("board_p", "");
		if (totalCnt % PER_PAGE == 0) {
			lastPageG = totalCnt / PER_PAGE;
		} else {
			lastPageG = totalCnt / PER_PAGE + 1;
		}
	}
}
