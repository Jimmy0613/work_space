package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcEdit {
	public static void run(int postNum) {
		String title = "";
		String content = "";
		boolean ox = true;

		Disp.menuPrint("[ 수정하기 ]");
		Cw.wn("*변동사항이 없을시 그냥 Enter만 입력*");
		title: while (true) {
			title = Ci.rl("제목(0~50자)");
			if (title.length() < 1) {
				break title;
			} else if (title.length() > 50) {
				Cw.wn("글자 수가 초과되었습니다.");
			} else
				break title;
		}
		content: while (true) {
			content = Ci.rl("내용");
			if (content.length() < 1) {
				break content;
			} else
				break content;
		}
		for (Post p : Data.postArray) {
			if (p.num == postNum) {
				if (title.length() == 0) {
					title = p.title;
				}
				if (content.length() == 0) {
					content = p.content;
				}
				Cw.dot();
				Cw.wn("제목:" + title);
				Cw.wn(content);
				Cw.w("이대로 수정할까요? o:적용 x:취소");
				while (true) {
					ProcMenu.input = Ci.r();
					switch (ProcMenu.input) {
					case "o":
						if (p.open == false) {
							Cw.wn("비공개 글입니다. 공개로 전환할까요? o:네 x:아니요");
							ProcMenu.input = Ci.r();
							if (ProcMenu.input.equals("x")) {
								ox = false;
								title = title + " 🔒";
							}
							Cw.wn("비공개 글입니다. 수정하시려면 암호를 입력하세요.");
							ProcMenu.input = Ci.r();
							if (!ProcMenu.input.equals(p.pw)) {
								Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
								ProcMenu.input = "x";
								return;
							}
						}
						p.title = title;
						p.content = content;
						p.open = ox;
						Cw.wn("수정했습니다.");
						ProcMenu.input = postNum + "";
						return;
					case "x":
						return;
					default:
						break;
					}
				}
			}
		}

	}
}
