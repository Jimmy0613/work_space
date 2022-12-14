package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcList {
	static String num = "";
	static int postNum = -1;

	public static void run() {
		// 목록 보여줌
		while (true) {
			getList();
			if (ProcMenu.input.equals("x")) {
				return;
			}
			// 선택한 글 보여줌
			post: while (true) {
				if (ProcMenu.input.equals("x")) {
					break post;
				}
				ProcRead.run();
				// 하단 메뉴 구동
				next: while (true) {
					if (ProcMenu.input.equals("x")) {
						break post;
					}
					ProcMenu.input = Ci.r();
					ProcRead.nextInput();
					break next;
				}
			}
		}
	}

	public static void getList() {

		Disp.menuPrint(" [ 목록 ] 조회하려면 글 번호를 입력하세요. (x:이전으로)");
		Cw.dot();
		Cw.wn(Cw.sf(" 번호 ", 4) + Cw.sf("| 작성자 ", 8) + Cw.sf("| 작성일 ", 12) + "|  제목");
		Cw.lineBar();
		if (Data.postArray.size() == 0) {
			Cw.wn("글이 없습니다. 처음으로 돌아갈게요.");
			Cw.wn(".");
			Cw.wn(".");
			ProcMenu.input = "x";
			return;
		} else {
			for (Post p : Data.postArray) {
				p.postInfoList();
			}
			Cw.lineBar();
		}
		ProcMenu.input = Ci.r();
	}

	

	
	

}
