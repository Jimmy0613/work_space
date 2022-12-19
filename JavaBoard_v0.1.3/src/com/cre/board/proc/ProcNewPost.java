package com.cre.board.proc;


import com.cre.board.Board;
import com.cre.board.db.DataInsert;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcNewPost {//글쓰기
	
	DataInsert di = new DataInsert();

	void run() {
		Disp.menuPrint(" [ 글쓰기 ] ");
		String title = "";
		String content;
		String writer = "";

		post: while (true) {
			writer: while (true) {
				writer = Ci.rl("글쓴이(최대 10자)(공백 입력시 익명)");
				if (writer.length() > 10) {
					Disp.menuPrint("<!> 글자 수가 초과되었습니다. (최대 10자)");
				} else
					break writer;
			}
			Cw.dot();
			Cw.wn("글쓴이:" + writer);
			title: while (true) {
				title = Ci.rl("제목(최대 250자)(공백 입력시 제목없음)");
				if (title.length() > 250) {
					Disp.menuPrint("<!> 글자 수가 초과되었습니다.");
				} else
					break title;
			}
			Cw.lineBar();
			Cw.dot();
			Cw.wn("글쓴이:" + writer + " 제목:" + title);
			Cw.lineBar();
			content: while (true) {
				content = Ci.rl("내용(최대 5000자)");
				if (content.length() < 1) {
					Disp.menuPrint("<!> 한 글자 이상 입력해주세요.");
				} else if (content.length() > 5000) {
					Disp.menuPrint("<!> 글자 수가 초과되었습니다.");
				} else
					break content;
			}
			Cw.lineBar();
			Cw.dot();
			Cw.wn("글쓴이:" + writer + " 제목:" + title);
			Cw.lineBar();
			Cw.wn();
			Cw.wn(content);
			Cw.wn();
			Disp.menuPrint("이대로 작성할까요? o:작성하기 x:취소하기");
			Board.input = Ci.r();
			while (true) {
				switch (Board.input) {
				case "o":
					di.dbPost(writer, title, content);
					break post;
				case "x":
					Disp.menuPrint("<!> 취소되었습니다.");
					break post;
				default:
					Board.input = Ci.r();
				}
			}
		}

	}
}
