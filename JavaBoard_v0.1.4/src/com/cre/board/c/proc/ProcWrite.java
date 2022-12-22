package com.cre.board.c.proc;


import com.cre.board.c.Board;
import com.cre.board.c.db.DataUpdate;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.Cw;
import com.cre.board.c.util.display.Disp;

public class ProcWrite {// 글/댓글쓰기
	DataUpdate du = new DataUpdate(); //executeUpdate로 하는 것들이 여기 있음

	public void newPost() {
		Disp.infoPrint(" [ 글쓰기 ] ");
		String title = ""; //글제목
		String content; //글내용
		String writer = ""; //글쓴이

		post: while (true) {
			if (Board.loginId.equals("")) { //비회원은 제약이 있음(Disp-notice확인)
				writer = "비회원";
			} else {
				writer = Board.loginId; //로그인상태면 로그인 사람 아이디로 
			}
			Cw.dot();
			Cw.wn("글쓴이:" + writer);
			title: while (true) { //입력 받음 250자 = sql에서 char(250)이라서.
				title = Ci.rl("제목(최대 250자)");
				if (title.length() > 250) {
					Disp.infoPrint("<!> 글자 수가 초과되었습니다.");
				} else if (title.length() < 1) {
					Disp.infoPrint("<!> 한 글자 이상 입력해주세요.");
				} else {
					break title;
				}
			}
			Cw.lineBar();
			Cw.dot();
			Cw.wn("글쓴이:" + writer + " 제목:" + title); //글쓴이랑 쓴 제목 보여줌..
			Cw.lineBar();
			content: while (true) {
				content = Ci.rl("내용");
				if (content.length() < 1) {
					Disp.infoPrint("<!> 한 글자 이상 입력해주세요.");
				} else if (content.length() > 5000) {
					Disp.infoPrint("<!> 글자 수가 초과되었습니다.");
				} else
					break content;
			}
			Cw.lineBar();
			Cw.dot();
			Cw.wn("글쓴이:" + writer + " 제목:" + title);
			Cw.lineBar();
			Cw.wn();
			Cw.wn(content);
			Cw.wn();
			Disp.infoPrint("이대로 쓸까요? [ o.작성 | x.취소 ]"); //굳이 한번더 물어봄... 안해도되는데 난 물어보는게 좋아서.. 이거 다 빼면 용량 1기가는 줄어들듯 ㅠ
			Board.input = Ci.r();
			while (true) {
				switch (Board.input) {
				case "o":
					du.insertPost(writer, title, content); //insert 쿼리 실행
					Disp.spaceln(5);

					break post; //목록으로 돌아갑니다..
				case "x":
					Disp.infoPrint("<!> 취소되었습니다."); //굳이 물어봐서 취소가능하게함
					Disp.spaceln(5);
					break post; 
				default:
					Board.input = Ci.r();
				}
			}
		}

	}
	public void reply() { //글쓰는거랑 과정 또옥같음
		String writer;
		String content;
		reply: while (true) {
			Disp.infoPrint("[ 댓글 쓰기 ]");
			if (Board.loginId.equals("")) {
				writer = "비회원";
			} else {
				writer = Board.loginId;
			}
			Cw.dot();
			Cw.wn("작성자:" + writer);
			content: while (true) {
				content = Ci.rl("내용(최대 5000자)");
				if (content.length() < 1) {
					Disp.infoPrint("<!> 한 글자 이상 입력해주세요.");
				} else if (content.length() > 5000) {
					Disp.infoPrint("<!> 글자 수가 초과되었습니다.");
				} else
					break content;
			}
			Cw.wn("작성자:" + writer + " 내용:" + content);
			Disp.infoPrint("[ 댓글 ] 이대로 쓸까요? 댓글은 삭제할 수 없어요. [ o.쓰기 | x.취소 ]");
			Board.input = Ci.r();
			while (true) {
				switch (Board.input) {
				case "o":
					du.insertReply(writer, content);
					Disp.spaceln(5);
					break reply;
				case "x":
					Disp.infoPrint("<!> 취소되었습니다.");
					Disp.spaceln(5);
					break reply;
				default:
					Board.input = Ci.r();
				}
			}
		}

	}
}
