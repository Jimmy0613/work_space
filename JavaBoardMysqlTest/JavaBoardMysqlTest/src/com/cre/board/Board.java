package com.cre.board;

import com.cre.board.display.Disp;

public class Board {
	public static final String VERSION = "v0.1.2";
	public static final String TITLE = "게시판 (" + VERSION + ")";
	public void run() {
		Disp.title();
		ProcMenu.run();
	}
}
