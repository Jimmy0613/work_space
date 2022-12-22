package com.cre.board.c;

import java.util.ArrayList;

import com.cre.board.c.db.DataGetInfo;
import com.cre.board.c.db.DataSelect;
import com.cre.board.c.db.DataUpdate;
import com.cre.board.c.util.Cw;
import com.cre.board.c.util.display.Disp;

public class PostAndReply {
	DataSelect ds = new DataSelect();
	DataGetInfo dgi = new DataGetInfo();
	DataUpdate du = new DataUpdate();

	public void post() {
		int cnt = 0; //있는 글인가 판단하기 위함
		du.updateHit(); //조회수 올림
		String where = "where post_num = " + GeneralBoard.postNum; //where절
		cnt = dgi.getCount("board_post", where); //해당 post_num에 글 몇개인지 확인. 0개면 안되니까
		if (cnt == 0) { // 0개면 안되지
			Disp.infoPrint("<!> 없는 번호입니다.");
			Board.input = "x";
			return;
		} else { // 0개 아니면(1개)
			String wr_id = ds.dbExecuteQueryStr("wr_id", "board_post", where); //이 함수 보고 오기.
			String date = ds.dbExecuteQueryStr("post_date", "board_post", where); //게시글은 테이블에서 딱 한줄만 필요하니까 arr말고 이거 쓰는거
			String title = ds.dbExecuteQueryStr("title", "board_post", where);
			String content = ds.dbExecuteQueryStr("content", "board_post", where);
			int hit = ds.dbExecuteQueryInt("hit", "board_post", where);
			int re_count = ds.dbExecuteQueryInt("re_count", "board_post", where);
			int like = ds.dbExecuteQueryInt("like_count", "board_post", where);
			Cw.lineLeo();
			if(Board.readOnly) { //읽기전용이면(인기글)
				//게시판 이름도 추가함.. 나중에 머 익명 게시판 이런것도 다같이 떠야해서 게시판 구분용. 사실 지금은 없어도 되는 정보.
				String b_name = ds.dbExecuteQueryStr("b_name", "board_post", where); 
				Disp.infoPrint(Cw.sf(" [" + b_name + "]", 6) + Cw.sf("[" + GeneralBoard.postNum + "]", 4) + " 제목: "
						+ title + " "); //실행해서 보세요 그냥 출력문인데 간격 맞춘거.. Cw.sf 이 함수 참고
				Cw.wn(Cw.sf("[글쓴이: " + wr_id, 12) + Cw.sf("|" + date, 15) + "]" + Cw.sf(" 조회수 " + hit, 10));
				Cw.wn();
				Cw.wn(" " + content);
				Cw.wn();
				Cw.lineBar();
				if (!wr_id.equals("비회원")) { //읽기전용이라서 개수들만 표시 함..
					Cw.wn("[댓글 " + re_count + "개] [ ❤ " + like + " ]");
				} else {
					Cw.wn("[댓글 " + re_count + "개]");
				}
				Cw.lineBar();
				reply(); //글 정보 다음 댓글 정보 띄우기. 바로 밑에 함수 잇음
				Cw.lineLeo();
			} else { //읽기전용 아니면(그냥 자게)
				Disp.infoPrint(Cw.sf("[" + GeneralBoard.postNum + "]", 4) + " " + title + " ");
				Cw.wn(Cw.sf("[ " + wr_id, 12) + Cw.sf("| " + date, 15) + "]" + Cw.sf(" 조회수 " + hit, 10));
				Cw.wn();
				Cw.wn(" " + content);
				Disp.spaceln(2);
				Cw.lineBar();
				if (!wr_id.equals("비회원")) { //읽기전용 아니라서 쓰기/보내기도 같이 표시 함..하트보내기가 추천같은거
					Cw.wn("[댓글 " + re_count + "개] [ ❤ " + like + " ] [ 1.댓글쓰기 | 2.❤ 보내기 ] ");
				} else {
					Cw.wn("[댓글 " + re_count + "개] [ 1.댓글쓰기 ] ");
				}
				Cw.lineBar();
				reply();
				Cw.wn();
				Cw.wn(" [ x.뒤로 | 3.이전글 | 4.다음글 ] [ 5.수정 | 6.삭제 ]"); //읽기전용아니라서22
				Cw.lineBar();
				Cw.lineLeo();
			}
		}

	}
	
	public void reply() { //댓글 정보 표시. 댓글이 여러개일수도 있기 때문에 arr씀. 나머진 같음
		int cnt = 0;
		String where = "where re_pnum = " + GeneralBoard.postNum;
		cnt = dgi.getCount("board_reply", where);
		if (cnt == 0) {
			Cw.wn("아직 댓글이 없어요.");
		} else {
		ArrayList<String> re_writer = ds.dbExecuteQueryStrArr("re_writer", "board_reply", where);
		ArrayList<String> re_content = ds.dbExecuteQueryStrArr("re_content", "board_reply", where);
		ArrayList<String> re_date = ds.dbExecuteQueryStrArr("re_date", "board_reply", where);
		if (re_writer.size() != 0) {
			for(int i = 0; i < re_writer.size(); i++) {
				String b = Cw.sf(" " + re_writer.get(i) + ":", 8) + re_content.get(i) + " (" + re_date.get(i) + ")";
				Cw.dot();
				Cw.wn(b);
			}
		}
	}
		Cw.lineBar();
	}

}
