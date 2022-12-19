package com.cre.board.proc;

import com.cre.board.Board;
import com.cre.board.db.DataInsert;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcReply {//댓글 (댓글 table 따로 있음)
	public static void run() {
		DataInsert di = new DataInsert();

		String writer;
		String content;
		reply: while (true) {
			Disp.menuPrint("[ 댓글 쓰기 ]");
			writer: while (true) {
				writer = Ci.rl("작성자(최대 10자)(공백 입력시 익명)");
				if (writer.length() > 10) {
					Disp.menuPrint("<!> 글자 수가 초과되었습니다. (최대 10자)");
				} else
					break writer;
			}
			Cw.dot();
			Cw.wn("작성자:" + writer);
			content: while (true) {
				content = Ci.rl("내용(최대 5000자)");
				if (content.length() < 1) {
					Disp.menuPrint("<!> 한 글자 이상 입력해주세요.");
				} else if (content.length() > 5000) {
					Disp.menuPrint("<!> 글자 수가 초과되었습니다.");
				} else
					break content;
			}
			Cw.wn("작성자:" + writer + " 내용:" + content);
			Disp.menuPrint("[ 댓글 ] 이대로 작성할까요? o:작성하기 x:취소하기");
			Board.input = Ci.r();
			while (true) {
				switch (Board.input) {
				case "o":
					di.dbReply(writer, content);
					break reply;
				case "x":
					Disp.menuPrint("<!> 취소되었습니다.");
					break reply;
				default:
					Board.input = Ci.r();
				}
			}
		}

	}
}
