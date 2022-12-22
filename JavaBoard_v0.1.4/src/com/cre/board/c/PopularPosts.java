package com.cre.board.c;

import com.cre.board.c.proc.ProcRead;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.display.Disp;

public class PopularPosts {
	
	ProcRead pr = new ProcRead();
	List dl = new List();

	public void run() {
		Board.readOnly = true;
		Disp.spaceln(5);

		list: while (true) {
			dl.popularPosts();//조회수 높은 글 10개만 가져옴 읽기전용
			Disp.spaceln(5);
			list2: while (true) {
				Board.input = Ci.r();
				if (Board.input.equals("x")) {
					return;
				}
				switch (Board.input) {
				case "1": //글읽기
					pr.readPost();
					break list2;
				case "x":
					break list;
				}
			}

		}
	}
}
