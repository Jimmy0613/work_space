package com.cre.board;

import com.cre.board.db.Database;
import com.cre.board.display.Disp;
import com.cre.board.proc.ProcGeneral;
import com.cre.board.proc.ProcNewPost;
import com.cre.util.Ci;
import com.cre.util.Cw;

public class Board {
	public static final String VERSION = "v0.1.3";
	public static final String TITLE = "게시판 (" + VERSION + ")";
	public static String input;
	static ProcNewPost prNp = new ProcNewPost();
	static ProcGeneral prGeneral = new ProcGeneral();

	public void run() {
		Database db = new Database();
		Disp.title();
		db.dbBoard();
		board: while (true) {
			Disp.menuPrint(" [ 1.자유게시판 x.종료 ] "); //초기화면을 게시판 이름으로 설정. 아직 자유게시판(general)만 있음
			input = Ci.r();
			switch (input) {
			case "1":
				prGeneral.run(); //자유게시판 진입
				break;
			case "x":
				Cw.wn("종료"); //프로그램 종료
				break board;
			}
		}
	}
}
