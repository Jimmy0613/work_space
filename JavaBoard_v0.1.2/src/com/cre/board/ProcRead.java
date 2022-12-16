package com.cre.board;

import com.cre.board.db.Database;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcRead {
	Database db = new Database();

	public void run() {
		while (true) {
			if (ProcMenu.input.equals("x")) {
				return;
			}
			db.dbRead(ProcList.postNum);
			next: while (true) {
				if (ProcMenu.input.equals("x")) {
					return;
				}
				ProcMenu.input = Ci.r();
				nextInput();
				break next;
			}
		}

	}

	// [ 이전글:1 | 목록:2 | 다음글:3 ] [수정:4][삭제:5]
	public void nextInput() {
		switch (ProcMenu.input) {
		case "1":
			int prePost = -1;

			if (prePost == -1) {
				Cw.wn("이전글이 없습니다. 목록으로 돌아갑니다.");
				ProcMenu.input = "x";
				return;
			} else {
				ProcMenu.input = prePost + "";
			}
			return;
		case "2":
			ProcMenu.input = "x";
			return;
		case "3":
			int nextPost = -1;

			if (nextPost == -1) {
				Cw.wn("다음글이 없습니다. 목록으로 돌아갑니다.");
				ProcMenu.input = "x";
				return;
			} else {
				ProcMenu.input = nextPost + "";
			}
			return;
		case "4":
			ProcEdit.run();
			return;
		case "5":
			ProcDel.run();
			return;
		case "r":
			ProcReply.run();
			return;
		default:
			return;
		}

	}
}
