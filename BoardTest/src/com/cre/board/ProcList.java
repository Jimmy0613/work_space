package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.data.Post;
import com.cre.util.Cw;

public class ProcList {
	public static void run() {
		if(Data.postArray.size() == 0) {
			Cw.wn("아직 글이 없어요.");
			return;
		} else {
			for(Post p: Data.postArray) {
				Cw.wn("<목록>");
				p.infoList();
			}
			return;
		}
	}
}
