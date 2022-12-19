package com.cre.board.proc;

import com.cre.board.Board;
import com.cre.board.db.DataPage;
import com.cre.board.db.DataSearch;
import com.cre.board.display.Disp;
import com.cre.util.Ci;

public class ProcSearch { // 검색 (글쓴이/제목으로 검색)
	public void search() {
		ProcGeneral pg = new ProcGeneral();
		DataSearch ds = new DataSearch();
		DataPage.limitS = 0;
		String keyword = "";
		String key = ""; // 쿼리에 들어갈 거..(title/wr_id)
		String keyS = ""; // 사용자에게 보여줄 거..(제목/글쓴이)
		screen0: while (true) { // 멀로 검색할지 선택
			Disp.menuPrint("[ 검색 ] 1.글쓴이로 검색 2.제목으로 검색 x:검색 취소");
			screen1: while (true) {

				Board.input = Ci.r();
				switch (Board.input) {
				case "1":
					key = "wr_id";
					keyS = "글쓴이";
					break screen1;
				case "2":
					key = "title";
					keyS = "제목";
					break screen1;
				case "x":
					break screen0;
				default:
					break;
				}
			}

			search: while (true) { // 검색 키워드 입력받음
				Disp.menuPrint("(" + keyS + "(으)로 검색) 키워드를 입력하세요. (x:다시 선택)");
				keyword = Ci.r();

				search2: while (true) { // 검색어 입력 후 목록 띄움

					if (keyword.equals("x")) {
						break search;
					}
					ds.dbSearch(key, keyword, DataPage.limitS);

					result: while (true) { // 검색 목록에서의 작업

						Board.input = Ci.r();
						switch (Board.input) {
						case "r": // 글읽기 똑같음
							Disp.menuPrint("글 번호를 입력하세요.");
							Board.input = Ci.r();
							if (Ci.isInteger(Board.input) == true) {
								ProcGeneral.postNum = Integer.parseInt(Board.input);
								pg.prRead.run();
								break result;
							} else
								break result;
						case "c": // 페이지이동 똑같음
							if (DataPage.pageS > 1) {
								DataPage.limitS -= DataPage.PER_PAGE;
								DataPage.pageS--;
								break result;
							} else {
								Disp.menuPrint("<!> 첫번째 페이지입니다.");
								break;
							}
						case "v":
							if (DataPage.pageS == DataPage.lastPageS) {
								Disp.menuPrint("<!> 마지막 페이지입니다.");
								break;
							} else {
								DataPage.limitS += DataPage.PER_PAGE;
								DataPage.pageS++;
								break result;
							}
						case "p":
							page: while (true) {
								Disp.menuPrint("[ 페이지 선택 ] 이동할 페이지 번호를 입력하세요. (취소:x)");
								Board.input = Ci.r();
								if (Board.input.equals("x")) {
									break page;
								}
								if (Ci.isInteger(Board.input) == true) {
									int p = Integer.parseInt(Board.input);
									if (1 <= p && p <= DataPage.lastPageS) {
										DataPage.pageS = p;
										DataPage.limitS = (p - 1) * DataPage.PER_PAGE;
										break result;
									} else {
										Disp.menuPrint("<!> 페이지 범위를 확인해주세요!");
									}
								} else {
									Disp.menuPrint("<!> 잘못된 입력입니다.");
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
