package com.cre.board.c.db;

import com.cre.board.c.Board;
import com.cre.board.c.GeneralBoard;
import com.cre.board.c.util.display.Disp;

public class DataGetInfo { //executeQuery로 '정보' 개념으로 가져올 것들.. 간단한거.
	DataSelect ds = new DataSelect();
	
	public int getCount(String table, String where) { //개수 구하기
		int count = 0;
		count = ds.dbExecuteQueryInt("count(*)", table, where);
		return count;
	}
	
	public int findFirstPost() { //첫글 넘버 구하기. 이전글/다음글 이동을 위해 필요함..
		int firstNum = ds.dbExecuteQueryInt("min(post_num)", "post_board", "");
		return firstNum;
	}

	public int findLastPost() { //마지막글 넘버
		int lastNum = ds.dbExecuteQueryInt("max(post_num)", "board_post", "");
		return lastNum;
	}

	public void findPrePost() { //이전글 찾기
		int preNum = 0;
		int cnt = 0;
		//현재글번호-1부터 시작해서 첫글 번호까지 순서대로 훑는다. 바로 직전에 번호가 있으면 그게 이전글이 되고 중간에 삭제된 번호가 있으면 패스하고 그 이전 글을 찾는다.
		findI: for (int i = GeneralBoard.postNum - 1; i >= findFirstPost(); i--) {
			//ex.현재 글이 3번인데 2번글이 삭제돼서 없으면 null포인트 익셉션이 발생함...그걸 방지하기 위해 미리 널체크 하는것..
			//https://eggwhite0.tistory.com/113 참고
			cnt = ds.dbExecuteQueryInt("ifnull(max(post_num),0)", "board_post", "where post_num = " + i);
			if (cnt != 0) { //널이 아니면 해당 번호를 preNum에 넣음
				preNum = ds.dbExecuteQueryInt("post_num", "board_post", "where post_num = " + i);
				break findI;
			}
		}
		if (preNum != 0) { //for문 끝까지 다 해서 결국 찾았으면
			GeneralBoard.postNum = preNum;
			return;
		} else { //끝까지 다했는데도 다 널이면
			Disp.infoPrint("<!> 이전글이 없습니다.");
			Board.input = "x";
			return;
		}
	}

	public void findNextPost() { //이전글이랑 또옥같음
		int nextNum = 0;
		int cnt = 0;
		findI: for (int i = GeneralBoard.postNum + 1; i <= findLastPost(); i++) {
			cnt = ds.dbExecuteQueryInt("ifnull(max(post_num),0)", "board_post", "where post_num = " + i);
			if (cnt != 0) {
				nextNum = ds.dbExecuteQueryInt("post_num", "board_post", "where post_num = " + i);
				break findI;
			}
		}
		if (nextNum != 0) {
			GeneralBoard.postNum = nextNum;
			return;
		} else {
			Disp.infoPrint("<!> 다음글이 없습니다.");
			Board.input = "x";
			return;
		}
	}

	public String findWrID() { //작성자 아이디 구함.
		String wrId = ds.dbExecuteQueryStr("wr_id", "board_post", "where post_num = " + GeneralBoard.postNum);
		return wrId;
	}
}
