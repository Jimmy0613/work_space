package com.cre.board.display;

import com.cre.board.Board;
import com.cre.util.Cw;

public class Disp {
	public static void title() {
		Cw.lineCre();
		Cw.dot();
		Cw.space(20);
		Cw.w(Board.TITLE);
		Cw.space(20);
		Cw.dot();
		Cw.wn();
		Cw.lineCre();
	}
	public static void menuPrint(String s) {
		Cw.lineBar();
		Cw.dot();
		Cw.w(" " + s + " ");
		Cw.dot();
		Cw.wn();
		Cw.lineBar();
	}

	
}
