package com.cre.board.proc;

import com.cre.board.Board;
import com.cre.board.db.DataPage;
import com.cre.board.db.Database;
import com.cre.board.display.Disp;
import com.cre.util.Ci;

public class ProcGeneral { //자유게시판
	public static int postNum = -1;
	ProcRead prRead = new ProcRead();


	public void run() {
		ProcNewPost pn = new ProcNewPost();
		Database db = new Database();
		ProcSearch ps = new ProcSearch();
		db.dbBoard();
		list: while (true) {
			db.dbList(DataPage.limit);//글 limit만큼씩 가져오기
			list2: while (true) {
				Board.input = Ci.r();
				if (Board.input.equals("x")) {
					return;
				}
				switch (Board.input) {
				case "c": //c:이전페이지
					if (DataPage.page > 1) {
						DataPage.limit -= DataPage.PER_PAGE;
						DataPage.page--;
						break list2;
					} else {
						Disp.menuPrint("<!> 첫번째 페이지입니다.");
						break;
					}
				case "v": //v:다음페이지
					if (DataPage.page == DataPage.lastPage) {
						Disp.menuPrint("<!> 마지막 페이지입니다.");
						break;
					} else {
						DataPage.limit += DataPage.PER_PAGE;
						DataPage.page++;
						break list2;
					}
				case "p": //p:페이지번호 입력해서 페이지 이동
					page: while (true) {
						Disp.menuPrint("[ 페이지 선택 ] 이동할 페이지 번호를 입력하세요. (취소:x)");
						Board.input = Ci.r();
						if (Board.input.equals("x")) {
							break page;
						}
						if (Ci.isInteger(Board.input) == true) {
							int p = Integer.parseInt(Board.input);
							if (1 <= p && p <= DataPage.lastPage) {
								DataPage.page = p;
								DataPage.limit = (p - 1) * DataPage.PER_PAGE;
								break list2;
							} else {
								Disp.menuPrint("<!> 페이지 범위를 확인해주세요!");
							}
						} else {
							Disp.menuPrint("<!> 잘못된 입력입니다.");
						}

					}
					break list2;
				case "n": //n:글쓰기
					pn.run();
					break list2;
				case "r": //r:글읽기
					Disp.menuPrint("[ 읽기 ] 글 번호를 입력하세요.");
					Board.input = Ci.r();
					if (Ci.isInteger(Board.input) == true) {
						postNum = Integer.parseInt(Board.input);
						prRead.run();
						break list2;
					} else
						break list2;
				case "s": //s:검색
					ps.search();
					break list2;
				case "x":
					break list;
				}
			}

		}
	}
	
	
}
