package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcRead {
	public static void run() {
		ProcList.run();
		if(Data.postArray.size()==0) return;
		Cw.wn("글 번호를 입력하세요.");
		String input = Ci.r();
		boolean isPost = false;
		for (Post p : Data.postArray) {
			if (input.equals(p.num + "")) {
				p.infoRead();
				isPost = true;
			}
		}
		if(isPost == false) {
			Cw.wn("없는 번호입니다.");
		}
		return;
	}
}
