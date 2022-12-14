package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcWrite {
	public static void run() {
		String writer = "";
		String title = "";
		String content = "";

		w: while (true) {
			Cw.wn("작성자: ");
			String input = Ci.r();
			if (input.length() < 1) {
				Cw.wn("한글자 이상 입력해주세요.");
			} else {
				writer = input;
				break w;
			}
		}
		t: while (true) {
			Cw.wn("제목: ");
			String input = Ci.r();
			if (input.length() < 1) {
				Cw.wn("한글자 이상 입력해주세요.");
			} else {
				title = input;
				break t;
			}
		}
		c: while (true) {
			Cw.wn("내용: ");
			String input = Ci.r();
			if (input.length() < 1) {
				Cw.wn("한글자 이상 입력해주세요.");
			} else {
				content = input;
				break c;
			}
		}
		
		Data.postArray.add(new Post(writer, title, content));
		Cw.wn("작성되었습니다.");
		return;
	}
}
