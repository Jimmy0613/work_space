package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcRead {
	public static void run() {
		if (ProcMenu.input.equals("x"))
			return;
		for (Post p : Data.postArray) {
			String n = p.num + "";
			if (n.equals(ProcMenu.input)) {
				if (p.open == false) {
					Cw.wn("비공개 글입니다. 암호를 입력하세요.");
					ProcMenu.input = Ci.r();
					if (!ProcMenu.input.equals(p.pw)) {
						Cw.wn("틀렸습니다. 목록으로 돌아갑니다.");
						ProcMenu.input = "x";
						return;
					}
				
				}
				ProcList.num = ProcMenu.input;
				ProcList.postNum = p.num;
				p.postInfo();
				
			}
		}
		if (ProcList.num.equals("")) {
			Cw.wn("없는 번호입니다.");
			ProcMenu.input = "x";
			return;
		}
	}

	// [ 이전글:1 | 목록:2 | 다음글:3 ] [수정:4][삭제:5]
	public static void nextInput() {
		switch (ProcMenu.input) {
		case "1":
			int prePost = -1;
			for (int i = ProcList.postNum - 1; i > 0; i--) {
				for (Post p : Data.postArray) {
					if (p.num == i) {
						prePost = i;
					}
				}
				if (prePost != -1)
					break;
			}
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
			for (int i = ProcList.postNum + 1; i <= Post.listNum; i++) {
				for (Post p : Data.postArray) {
					if (p.num == i) {
						nextPost = i;
					}
				}
				if (nextPost != -1)
					break;
			}
			if (nextPost == -1) {
				Cw.wn("다음글이 없습니다. 목록으로 돌아갑니다.");
				ProcMenu.input = "x";
				return;
			} else {
				ProcMenu.input = nextPost + "";
			}
			return;
		case "4":
			ProcEdit.run(ProcList.postNum);
			return;
		case "5":
			Cw.wn("정말 삭제하시겠어요? (o:삭제 x:취소)");
			ProcMenu.input = Ci.r();
			switch (ProcMenu.input) {
			case "o":
				ProcDel.run(ProcList.postNum);
				break;
			default:
				Cw.wn("목록으로 돌아갑니다.");
			}
			ProcMenu.input = "x";
			return;
		case "r":
			ProcReply.run();
			return;
		default:
			return;
		}

	}
}
