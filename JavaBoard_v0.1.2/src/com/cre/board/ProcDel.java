package com.cre.board;

import com.cre.board.db.Database;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcDel {
	public static void run() {
		Database db = new Database();
		Cw.wn("정말 삭제하시겠어요? (o:삭제 x:취소)");
		ProcMenu.input = Ci.r();
		switch (ProcMenu.input) {
		case "o":
			db.dbDel(ProcList.postNum);
			Cw.wn("삭제되었습니다.");
			break;
		default:
			Cw.wn("목록으로 돌아갑니다.");
		}
		ProcMenu.input = "x";
		return;

	}

}
