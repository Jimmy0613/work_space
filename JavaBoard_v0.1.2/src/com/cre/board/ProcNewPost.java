package com.cre.board;

import java.time.LocalDate;

import com.cre.board.db.Database;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcNewPost {
	LocalDate now = LocalDate.now();
	String date;
	Database db = new Database();

	void run() {
		Disp.menuPrint(" [ 글쓰기 ] ");
		String title = "";
		String content;
		String writer = "";

		post: while (true) {
			writer: while (true) {
				writer = Ci.rl("작성자(최대 10자)(공백 입력시 익명)");
				if (writer.length() > 10) {
					Cw.wn("글자 수가 초과되었습니다. (최대 10자)");
				} else
					break writer;
			}
			Cw.dot();
			Cw.wn("작성자:" + writer);
			title: while (true) {
				title = Ci.rl("제목(최대 250자)(공백 입력시 제목없음)");
				if (title.length() > 250) {
					Cw.wn("글자 수가 초과되었습니다.");
				} else
					break title;
			}
			Cw.lineBar();
			Cw.dot();
			Cw.wn("작성자:" + writer + " 제목:" + title);
			Cw.lineBar();
			content: while (true) {
				content = Ci.rl("내용(최대 5000자)");
				if (content.length() < 1) {
					Cw.wn("한 글자 이상 입력해주세요.");
				} else if (content.length() > 5000) {
					Cw.wn("글자 수가 초과되었습니다.");
				} else
					break content;
			}
			Cw.lineBar();
			Cw.dot();
			Cw.wn("작성자:" + writer + " 제목:" + title);
			Cw.lineBar();
			Cw.wn();
			Cw.wn(content);
			Cw.wn();
			Cw.w("이대로 작성할까요? o:작성하기 x:취소하기");
			ProcMenu.input = Ci.r();
			while (true) {
				switch (ProcMenu.input) {
				case "o":
					date = now.toString();
					if (title.equals("")) {
						db.dbWrite("insert into board_post (wr_id, content, date) values ('" + writer + "', '" + content
								+ "', '" + date + "');");
					} else if (writer.equals("")) {
						db.dbWrite("insert into board_post (title, content, date) values ('" + title + "', '" + content
								+ "', '" + date + "');");
					} else if (writer.equals("x") && title.equals("x")) {
						db.dbWrite(
								"insert into board_post (content, date) values ('" + content + "', '" + date + "');");
					} else {
						db.dbWrite("insert into board_post (title, wr_id, content, date) values ('" + title + "', '"
								+ writer + "', '" + content + "', '" + date + "');");
					}
					break post;
				case "x":
					Cw.wn("취소되었습니다.");
					break post;
				default:
					ProcMenu.input = Ci.r();
				}
			}
		}

	}
}
