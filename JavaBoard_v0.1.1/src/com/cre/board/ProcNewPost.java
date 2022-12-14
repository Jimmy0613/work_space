package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcNewPost {
	public static void run() {
		Disp.menuPrint(" [ 글쓰기 ] ");
		String title;
		String content;
		String writer;
		String pw = "";
		boolean ox = true;
		post: while (true) {
			Cw.wn("1:공개글 2:비공개글 x:이전으로");
			String input = Ci.r();
			open: while (true) {
				switch (input) {
				case "x":
					break post;
				case "1":
					break open;
				case "2":
					ox = false;
					Cw.wn("암호를 입력하세요.(4글자)");
					input = Ci.r();
					pw: while (true) {
						if (input.length() != 4) {
							Cw.wn("글자 수를 확인해주세요!(4글자)");
							input = Ci.r();
						} else {
							pw = input;
							break pw;
						}
					}
					break open;
				default:
					input = Ci.r();
				}
			}
			writer: while (true) {
				writer = Ci.rl("작성자(1~6자)");
				if (writer.length() < 1 || writer.length() > 6) {
					Cw.wn("글자 수를 확인해주세요!(1~6자)");
				} else
					break writer;
			}
			Cw.dot();
			Cw.wn("작성자:" + writer);
			title: while (true) {
				title = Ci.rl("제목(0~100자)");
				if (title.length() < 1) {
					title = "(제목없음)";
					break title;
				} else if (title.length() > 100) {
					Cw.wn("글자 수가 초과되었습니다.");
				} else
					break title;
			}
			Cw.lineBar();
			Cw.dot();
			Cw.wn("작성자:" + writer + " 제목:" + title);
			Cw.lineBar();
			content: while (true) {
				content = Ci.rl("내용");
				if (content.length() < 1) {
					Cw.wn("한 글자 이상 입력해주세요.");
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
					if (ox == false) {
						title = title + " 🔒";
					}
					Data.postArray.add(new Post(title, content, writer, ox, pw));
					break post;
				case "x":
					break post;
				default:
					ProcMenu.input = Ci.r();
				}
			}
		}

	}
}
