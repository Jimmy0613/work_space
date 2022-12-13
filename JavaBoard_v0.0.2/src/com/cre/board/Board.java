package com.cre.board;

import com.cre.board.data.Data;
import com.cre.board.display.Disp;

public class Board {
	public static final String VERSION = "v0.0.2";
	public static final String TITLE = "게시판 (" + VERSION + ")";
	public void run() {
		Data.loadData();
		Disp.title();
		ProcMenu.run();
	}
}
