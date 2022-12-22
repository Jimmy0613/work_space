package com.cre.board.c;

import com.cre.board.c.proc.ProcRead;
import com.cre.board.c.proc.ProcSearch;
import com.cre.board.c.proc.ProcWrite;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.display.Disp;

public class GeneralBoard { //자유게시판
	public static int postNum = -1; //글번호. input처럼 이것도 하나로 관리해야 편함.
	
	ProcRead pr = new ProcRead(); //읽기과정
	ProcWrite pw = new ProcWrite(); //쓰기과정(글,댓글)
	List li = new List(); //각종 목록들
	ProcSearch sh = new ProcSearch(); //검색


	public void run() {
		list: while (true) {
			Board.readOnly = false; //읽기 전용이 아니므로
			li.generalBoard(Page.startIndex); //자유게시판 글 목록!
			Disp.spaceln(5);
			list2: while (true) {
				Board.input = Ci.r();
				if (Board.input.equals("x")) { //자주 나오는 식. 
					return;
				}
				switch (Board.input) {
				case "1": //글쓰기
					pw.newPost();
					break list2;
				case "2": //글읽기
					pr.readPost();
					break list2;
				case "3": //검색
					sh.search();
					break list2;
				case "4": //이전페이지
					if (Page.currentPage > 1) { //1페이지는 앞으로 갈수없잔아
						Page.startIndex -= Page.PER_PAGE; //시작인덱스를 페이지당 글수만큼 앞으로 땡깁니다
						Page.currentPage--; 
						break list2;
					} else {
						Disp.infoPrint("<!> 첫번째 페이지입니다.");
						break;
					}
				case "5": //다음페이지. 이전페이지랑 반대로 하면 됩니다.
					if (Page.currentPage == Page.lastPage) {
						Disp.infoPrint("<!> 마지막 페이지입니다.");
						break;
					} else {
						Page.startIndex += Page.PER_PAGE;
						Page.currentPage++;
						break list2;
					}
				case "6": //페이지번호 입력해서 페이지 이동
					page: while (true) {
						Disp.infoPrint("[ 페이지 선택 ] 이동할 페이지 번호를 입력하세요. (x.취소)");
						Board.input = Ci.r();
						if (Board.input.equals("x")) {
							break page;
						}
						if (Ci.isInteger(Board.input) == true) { //글번호 입력 받을 때 처럼..
							int p = Integer.parseInt(Board.input);
							if (1 <= p && p <= Page.lastPage) { //1~마지막페이지(미리구함) 사이의 범위
								Page.currentPage = p;
								Page.startIndex = (p - 1) * Page.PER_PAGE;
								break list2;
							} else {
								Disp.infoPrint("<!> 페이지 범위를 확인해주세요!");
							}
						} else {
							Disp.infoPrint("<!> 잘못된 입력입니다.");
						}

					}
					break list2;
				case "x":
					break list;
				}
			}

		}
	}
	
	
}
