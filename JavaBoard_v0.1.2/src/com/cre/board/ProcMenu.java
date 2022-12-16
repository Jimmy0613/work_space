package com.cre.board;

import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcMenu {
	public static String input;
	static ProcNewPost prNp = new ProcNewPost();
	static ProcList prList = new ProcList();
	public static void run() {
		board: while (true) {
			Disp.menuPrint(" [ 1.목록 2.글쓰기 x.종료 ] ");
			input = Ci.r();
			switch (input) {
			case "1":
				prList.run();
				break;
			case "2":
				prNp.run();
				break;
			case "x":
				Cw.wn("종료");
				break board;
			}
		}
	}
}
