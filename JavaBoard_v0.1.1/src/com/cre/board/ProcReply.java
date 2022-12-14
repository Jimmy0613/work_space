package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.board.data.Reply;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcReply {

	public static void run() {
		String writer;
		String comment;
		writer: while (true) {
			writer = Ci.rl("작성자(1~6자)");
			if (writer.length() < 1 || writer.length() > 6) {
				Cw.wn("글자 수를 확인해주세요!(1~6자)");
			} else
				break writer;
		}
		comment: while (true) {
			comment = Ci.rl("내용");
			if (comment.length() < 1) {
				Cw.wn("한 글자 이상 입력해주세요.");
			} else
				break comment;
		}
		Cw.wn("작성자:" + writer + " 내용:" + comment);
		Cw.wn("이대로 작성할까요? o:작성하기 x:취소하기");
		reply: while (true) {
			ProcMenu.input = Ci.r();
			switch (ProcMenu.input) {
			case "o":
				Post.comments.add(new Reply(ProcList.postNum, writer, comment));
				for(Post p: Data.postArray) {
					if(p.num == ProcList.postNum) {
						p.re++;
						break;
					}
				}
				ProcMenu.input = ProcList.postNum + "";
				break reply;
			case "x":
				Cw.wn("취소되었습니다.");
				break reply;
			default:
				break;
			}
		}
	}

}
