package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class Board {
	public final static String VERSION = "(v.test)";
	public final static String TITLE = "게시판 " + VERSION;

	public void run() {
		Disp.title();
		Data.loadData();

		b: while (true) {

			Disp.menuPrint("1.목록 2.읽기 3.글쓰기 4.삭제 5.수정 x.종료");
			Cw.wn("명령을 입력하세요.");
			String input = Ci.r();
			switch (input) {
			case "1":
				ProcList.run();
				break;
			case "2":
				ProcRead.run();
				break;
			case "3":
				ProcWrite.run();
				break;
			case "4":
				ProcDel.run();
				break;
			case "5":
				ProcEdit.run();
				break;
			case "x":
				Cw.wn("종료합니다.");
				break b;

			}
		}
	}
}
