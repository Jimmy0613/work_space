package com.cre.board.c.proc;

import com.cre.board.c.Board;
import com.cre.board.c.GeneralBoard;
import com.cre.board.c.Page;
import com.cre.board.c.db.DataUpdate;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.Cw;
import com.cre.board.c.util.display.Disp;

public class ProcEditAndDelete { //글수정/글삭제
	
	DataUpdate du = new DataUpdate();

	public void edit() {
		String title = "";
		String content = "";

		Disp.infoPrint("[ 수정 ] *변동사항이 없을시 그냥 Enter만 입력*");
		title: while (true) {
			title = Ci.rl("제목(최대 250자)");
			if (title.length() < 1) {
				break title;
			} else if (title.length() > 250) {
				Cw.wn("글자 수가 초과되었습니다.");
			} else
				break title;
		}
		content: while (true) {
			content = Ci.rl("내용(최대 5000자)");
			if (content.length() < 1) {
				break content;
			} else if (title.length() > 5000) {
				Cw.wn("글자 수가 초과되었습니다.");
			} else
				break content;
		}
		Cw.dot();
		Cw.wn(" 제목: " + title);
		Cw.wn("  내용: " + content);
		Disp.infoPrint("[ 수정 ] 이대로 수정할까요? [ o.적용 x.취소 ]");
		while (true) {
			Board.input = Ci.r();
			switch (Board.input) {
			case "o":
				du.editPost(title, content);
				Disp.spaceln(5);
				return;
			case "x":
				Disp.spaceln(5);
				return;
			default:
				break;
			}
		}
	}
	public void delete() {
		Disp.infoPrint("[ 삭제 ] 정말 삭제하시겠어요? [ o.삭제 x.취소 ]");
		Board.input = Ci.r();
		switch (Board.input) {
		case "o":
			du.deletePost(GeneralBoard.postNum);
			Disp.infoPrint("삭제되었습니다.");
			// 삭제 후 페이지 자체가 사라지게 되면 페이지 이동이 잘 안되어서 그냥 1페이지로 돌아가게..
			Page.currentPage = 1;
			Page.startIndex = 0;
			Page.currentPageS = 1;
			Page.startIndexS = 0;
			break;
		default:
			Disp.infoPrint("목록으로 돌아갑니다.");
			Disp.spaceln(5);

		}
		Disp.spaceln(5);
		Board.input = "x";
		return;

	}

}
