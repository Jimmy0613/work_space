package com.cre.board;

import com.cre.board.db.Database;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcList {
	static int postNum = -1;
	static ProcRead prRead = new ProcRead();

	void run() {
//		 목록 보여줌
		while (true) {
			getList();
			if (ProcMenu.input.equals("x")) {
				return;
			}
//			 선택한 글 보여줌
			prRead.run();
			// 하단 메뉴 구동
		}
	}

	public void getList() {
		Database db = new Database();
		Disp.menuPrint(" [ 목록 ] 조회하려면 글 번호를 입력하세요. (x:이전으로)");
		Cw.dot();
		Cw.wn(Cw.sf(" 번호 ", 4) + Cw.sf("| 작성자 ", 10) + Cw.sf("| 제목 ", 40) + Cw.sf("| 조회수 ", 10));
		Cw.lineBar();

		db.dbList();
		while(true) {
		ProcMenu.input = Ci.r();
		if (Ci.isInteger(ProcMenu.input)==true) {
			postNum = Integer.parseInt(ProcMenu.input);
			break;
		} else break;
		}
	}

}
