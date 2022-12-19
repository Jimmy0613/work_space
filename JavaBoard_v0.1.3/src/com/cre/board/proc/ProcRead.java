package com.cre.board.proc;

import com.cre.board.Board;
import com.cre.board.db.Database;
import com.cre.util.Ci;

public class ProcRead { //읽기
	Database db = new Database();

	public void run() {
		while (true) {
			if (Board.input.equals("x")) {
				return;
			}
			db.dbRead(ProcGeneral.postNum);
			next: while (true) {
				if (Board.input.equals("x")) {
					return;
				}
				Board.input = Ci.r();
				nextInput();
				break next;
			}
		}

	}

	// 글읽기 할 때 하단메뉴.. [ 목록:x | 수정:e | 삭제:d]
	public void nextInput() {
		while(true) {
			
		switch (Board.input) {
		case "x":
			Board.input = "x";
			return;
		case "e":
			ProcEdit.run();
			return;
		case "d":
			ProcDel.run();
			Board.input = "x";
			return;
		case "r":
			ProcReply.run();
			return;
		default:
			Board.input = Ci.r();
		}
		}

	}
}
