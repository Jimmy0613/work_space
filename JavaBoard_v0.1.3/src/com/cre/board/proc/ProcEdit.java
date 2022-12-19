package com.cre.board.proc;

import com.cre.board.Board;
import com.cre.board.db.DataUpdate;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcEdit { //글수정(작성자 수정 불가능)
	public static void run() {
		DataUpdate du = new DataUpdate();
		String title = "";
		String content = "";

		Disp.menuPrint("[ 수정 ] *변동사항이 없을시 그냥 Enter만 입력*");
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
		Disp.menuPrint("[ 수정 ] 이대로 수정할까요? o:적용 x:취소");
		while (true) {
			Board.input = Ci.r();
			switch (Board.input) {
			case "o":
				du.dbEdit(title, content);
				return;
			case "x":
				return;
			default:
				break;
			}
		}
	}

}
