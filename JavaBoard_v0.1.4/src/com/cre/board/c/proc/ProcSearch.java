package com.cre.board.c.proc;

import com.cre.board.c.Board;
import com.cre.board.c.List;
import com.cre.board.c.Page;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.display.Disp;

public class ProcSearch { // 검색 (글쓴이/제목으로 검색)
	List li = new List();
	ProcRead prRead = new ProcRead();

	public void search() {
		Page.startIndexS = 0; //limit에 s붙인거(검색페이지 전용 리밋.. Page 클래스 가보면 있음)
		String keyword = ""; //**검색키워드
		String key = ""; // 쿼리에 들어갈 거..(title/wr_id) 뭘로검색할지?
		String keyS = ""; // 사용자에게 보여줄 거..(제목/글쓴이) 말그대로.
		screen0: while (true) { // 멀로 검색할지 선택
			Disp.infoPrint("[ 검색 ] 1.글쓴이로 검색 2.제목으로 검색 x.검색 취소");
			
			screen1: while (true) {
				Board.input = Ci.r();
				switch (Board.input) {
				case "1":
					key = "wr_id";
					keyS = "글쓴이";
					break;
				case "2":
					key = "title";
					keyS = "제목";
					break;
				case "x":
					break screen0;
				}

			search: while (true) { // 뭘로할지 정했으면 검색 키워드 입력받음
				Disp.infoPrint("(" + keyS + "(으)로 검색) 키워드를 입력하세요. [ x.다시 선택 ]");
				Board.input = Ci.r();
				if(Board.input.equals("x")) {
					break screen1;
				}
				keyword = Board.input;
				Page.startIndex = 0;
				Page.currentPageS = 1;
				
				search2: while (true) { // 검색어 입력 후 목록 띄움
					li.searchList(key, keyword, Page.startIndexS);
					Disp.spaceln(5);

					result: while (true) { // 검색 목록에서의 작업
						
						Board.input = Ci.r();
						switch (Board.input) {
						case "1": // 글읽기 똑같음
							Board.readOnly = true;
							prRead.readPost();
							break result;
						case "4": // 페이지이동 똑같음
							if (Page.currentPageS > 1) {
								Page.startIndexS -= Page.PER_PAGE;
								Page.currentPageS--;
								Disp.spaceln(5);
								break result;
							} else {
								Disp.infoPrint("<!> 첫번째 페이지입니다.");
								break;
							}
						case "5":
							if (Page.currentPageS == Page.lastPageS) {
								Disp.infoPrint("<!> 마지막 페이지입니다.");
								break;
							} else {
								Page.startIndexS += Page.PER_PAGE;
								Page.currentPageS++;
								Disp.spaceln(5);
								break result;
							}
						case "6":
							page: while (true) {
								Disp.infoPrint("[ 페이지 선택 ] 이동할 페이지 번호를 입력하세요. [ x.취소 ])");
								Board.input = Ci.r();
								if (Board.input.equals("x")) {
									break page;
								}
								if (Ci.isInteger(Board.input) == true) {
									int p = Integer.parseInt(Board.input);
									if (1 <= p && p <= Page.lastPageS) {
										Page.currentPageS = p;
										Page.startIndexS = (p - 1) * Page.PER_PAGE;
										Disp.spaceln(5);
										break result;
									} else {
										Disp.infoPrint("<!> 페이지 범위를 확인해주세요!");
									}
								} else {
									Disp.infoPrint("<!> 잘못된 입력입니다.");
								}

							}
							break result;
						case "x":
							break search2;
						}
					}
				}
			}
			}
		}
	}
}
