package com.cre.board.c.util.display;

import com.cre.board.c.Board;
import com.cre.board.c.List;
import com.cre.board.c.Page;
import com.cre.board.c.db.DataUpdate;
import com.cre.board.c.util.Cw;

public class Disp {
	public static void title() {
		Cw.lineLeo();
		Cw.dot();
		Cw.space(60);
		Cw.dot();
		Cw.wn();
		Cw.dot();
		Cw.space(23);
		Cw.w(Board.TITLE);
		Cw.space(24);
		Cw.dot();
		Cw.wn();
		Cw.dot();
		Cw.space(60);
		Cw.dot();
		Cw.wn();
		Cw.lineLeo();
	}

	public static void notice() {
		Disp.infoPrint(" [ 📢 공지사항 📢 ] ");
		Cw.wn("1.회원/비회원제입니다. 로그인 하지 않을 시 비회원으로 표시됩니다.");
		Cw.wn("ㄴ 비회원은 게시글 추천을 하거나 받을 수 없습니다.");
		Cw.wn("ㄴ 최초 가입 시 일반 회원입니다.");
		Cw.wn("ㄴ 게시글 5개 작성 시 열심 회원이 됩니다.");
		Cw.wn("ㄴ 게시글 10개 작성 시 최고 회원이 됩니다.");
		Cw.wn("ㄴ 게시글을 삭제할 경우 회원 등급이 내려갈 수 있습니다.");
		Cw.wn("2.오늘의 BEST: 오늘 작성된 글 중 가장 하트(❤)를 많이 받은 글 3개를 보여줍니다.");
		Cw.wn("3.인기글: 모든 글 중 가장 조회수가 높은 글 10개를 보여줍니다.");
		Cw.wn("4.게시글 작성 시 줄바꿈: '\\n'을 입력하세요.");
	}
	
	public static void home() {
		title();
		List dl = new List();
		if (Board.loginId.equals("")) { //로그인/로그아웃 상태에 따라 바뀜..
			Disp.infoPrint(" [ 1.자유게시판 | 2.인기글 | x.종료 ] [ 3.로그인 | 4.회원가입 ]");
			Cw.wn("[ 🍒 회원정보 🍒 ] 로그인하세요.");
		} else {
			DataUpdate du = new DataUpdate();
			du.updateLoginInfo();
			Disp.infoPrint(" [ 1.자유게시판 | 2.인기글 | x.종료 ] [ 3.로그아웃 ]");
			Cw.wn("[ 🍒 회원정보 🍒 ] " + Board.loginId + " 님 (등급: " + Board.loginGrade + ")");
		}
		notice();
		dl.todayBest();
		Cw.lineLeo();
	}

	public static void infoPrint(String s) {
		Cw.lineBar();
		Cw.wn("❤🖤❤" + s + "❤🖤❤");
		Cw.lineBar();
	}

	public static void spaceln(int n) {
		for (int i = 0; i < n; i++) {
			Cw.wn();
		}
	}

	public static void boardTitle(String str) {
		Cw.lineLeo();
		Cw.lineBar();
		Cw.wn(Cw.LEO + str + " " + Cw.LEO);
		Cw.lineBar();
		Cw.lineLeo();
	}

	public static void dispPageInfo(int page, int lastPage) {
		Cw.w(" 페이지 [ 현재:" + page + " ]");
		if (page <= 3) {
			for (int i = 1; i <= Page.PER_PAGE && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" (" + i + ")");
				} else {
					Cw.w(" " + i);
				}
			}
			Cw.w(" ..");
		} else if (page >= lastPage - 2) {
			Cw.w(" ..");
			for (int i = lastPage - 4; i <= page + 2 && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" (" + i + ")");
				} else {
					Cw.w(" " + i);
				}
			}
		} else {
			Cw.w(" ..");
			for (int i = page - 2; i <= page + 2 && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" (" + i + ")");
				} else {
					Cw.w(" " + i);
				}
			}
			Cw.w(" ..");
		}
		Cw.wn(" [ 마지막:" + lastPage + " ] [ 4.이전 | 5.다음 | 6.선택 ]");
		Cw.lineBar();
	}

}
