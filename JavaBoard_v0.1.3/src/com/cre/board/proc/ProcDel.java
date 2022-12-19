package com.cre.board.proc;

import com.cre.board.Board;
import com.cre.board.db.DataPage;
import com.cre.board.db.DataUpdate;
import com.cre.board.display.Disp;
import com.cre.util.Ci;

public class ProcDel { //글삭제
	public static void run() {
		
		DataUpdate du = new DataUpdate();
		
		Disp.menuPrint("[ 삭제 ] 정말 삭제하시겠어요? (o:삭제 x:취소)");
		Board.input = Ci.r();
		switch (Board.input) {
		case "o":
			du.dbDel(ProcGeneral.postNum);
			Disp.menuPrint("삭제되었습니다.");
			// 삭제 후 페이지 자체가 사라지게 되면 페이지 이동이 잘 안되어서 그냥 1페이지로 돌아가게..
			DataPage.page = 1;
			DataPage.limit = 0;
			DataPage.pageS = 1;
			DataPage.limitS = 0;
			break;
		default:
			Disp.menuPrint("목록으로 돌아갑니다.");
		}
		Board.input = "x";
		return;

	}

}
