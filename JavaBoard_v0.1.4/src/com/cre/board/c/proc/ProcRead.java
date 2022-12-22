package com.cre.board.c.proc;

import com.cre.board.c.Board;
import com.cre.board.c.GeneralBoard;
import com.cre.board.c.PostAndReply;
import com.cre.board.c.db.DataGetInfo;
import com.cre.board.c.db.DataUpdate;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.display.Disp;

public class ProcRead { // 읽기(모든 읽기. 자게 / 인기글)
	DataGetInfo dgi = new DataGetInfo(); // executeQuery로 간단하게 정보 가져오는 것들 모음..카운트같은거
	ProcWrite pw = new ProcWrite(); //글 댓글 쓰는 클래스
	ProcEditAndDelete ped = new ProcEditAndDelete(); //수정, 삭제
	DataUpdate du = new DataUpdate();
	PostAndReply pr = new PostAndReply(); //글 댓글 가져오는 클래스

	public void readPost() { //읽기 선택하면 뜨는 거
		while (true) {
			Disp.infoPrint("[ 읽기 ] 글 번호를 입력하세요. [ x.목록 ]");
			input: while (true) {
				Board.input = Ci.r();
				if (Board.input.equals("x")) {
					return;
				}
				if (Ci.isInteger(Board.input) == true) { // input이 String 타입이라 거치는 과정.input이 정수이면 true
					GeneralBoard.postNum = Integer.parseInt(Board.input); //그럼 parseInt해서 STring을 int로 바꿈
					break input;
				} else {
					Disp.infoPrint("<!> 잘못된 입력입니다."); //숫자 아니면 뜨는거
				}
			}
			showPost(Board.readOnly); //읽기전용인지 아닌지 판단해서 글 보여주는 함수로 감.
			Disp.spaceln(5);

		}
	}

	public void showPost(boolean readOnly) { //글 보여주는 함수.
		read: while (true) {
			if (Board.input.equals("x")) {
				break read;
			}
			pr.post(); //글 보여줌
			Disp.spaceln(5);
			next: while (true) {
				if (Board.input.equals("x")) {
					break read;
				}
				inPost();
				break next;
			}
		}
	}

	// 글읽기 할 때 하단메뉴.. [ x:뒤로 |5:수정 | 6:삭제 ] [ 3:이전글 | 4:다음글 ] 1:댓글쓰기 2:추천
	public void inPost() {
		while (true) {
			Board.input = Ci.r();
			switch (Board.input) {
			case "x":
				Board.input = "x";
				return;
			case "1":
				pw.reply();
				Disp.spaceln(5);
				return;
			case "2":
				if (dgi.findWrID().equals("비회원")) {
					break;
				} else {
					like();
					Disp.spaceln(5);
					return;
				}
			case "3":
				dgi.findPrePost();
				if (Board.input.equals("x")) {
					break;
				}
				showPost(Board.readOnly);
				Disp.spaceln(5);
				return;
			case "4":
				dgi.findNextPost();
				if (Board.input.equals("x")) {
					break;
				}
				showPost(Board.readOnly);
				Disp.spaceln(5);
				return;
			case "5":
				ped.edit();
				Disp.spaceln(5);
				return;
			case "6":
				ped.delete();
				Disp.spaceln(5);
				Board.input = "x";
				return;
			}
		}
	}
	
	public void like() {
		if (Board.loginId.equals("")) {
			Disp.infoPrint("비회원은 할 수 없어요.");
			return;
		} else {
			Disp.infoPrint("하트(❤)를 보낼까요? [ o.좋아요 x.취소 ]");
			Board.input = Ci.r();
			switch (Board.input) {
			case "o":
				du.updateLike();
				Disp.infoPrint("하트(❤)를 보냈어요!");
				return;
			case "x":
				return;
			}
		}
	}
}
