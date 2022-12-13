package com.cre.board;

import com.cre.board.display.Disp;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class ProcMenu {
	public static void run() {
		board: while (true) {
			Disp.menuPrint(" [ 1.목록 2.글쓰기 x.종료 ] ");
			String input = Ci.r();
			switch (input) {
			case "1":
				ProcList.run();
				break;
			case "2":
				ProcNew.run();
				break;
			case "x":
				Cw.wn("종료");
				break board;
			}
		}
	}
}
