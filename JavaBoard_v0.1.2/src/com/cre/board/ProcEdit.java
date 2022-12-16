package com.cre.board;

import com.cre.board.db.Database;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcEdit {
	public static void run() {
		Database db = new Database();
		String title = "";
		String content = "";

		Disp.menuPrint("[ 수정하기 ]");
		Cw.wn("*변동사항이 없을시 그냥 Enter만 입력*");
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
		Cw.wn("제목:" + title);
		Cw.wn(content);
		Cw.w("이대로 수정할까요? o:적용 x:취소");
		while (true) {
			ProcMenu.input = Ci.r();
			switch (ProcMenu.input) {
			case "o":
				if(title.equals("")) {
					db.dbEdit("update board_post set content='" + content + "' where post_num = " + ProcList.postNum);
				} else if(content.equals("")) {
					db.dbEdit("update board_post set title='" + title +"' where post_num = " + ProcList.postNum);
				} else {
					db.dbEdit("update board_post set title='" + title +"', content='" + content + "' where post_num = " + ProcList.postNum);
				}
				Cw.wn("수정했습니다.");
				ProcMenu.input = ProcList.postNum + "";
				return;
			case "x":
				return;
			default:
				break;
			}
		}
	}

}
