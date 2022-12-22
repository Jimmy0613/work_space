package com.cre.board.c.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cre.board.c.Board;
import com.cre.board.c.GeneralBoard;
import com.cre.board.c.util.display.Disp;

public class DataUpdate { //executeUpdate로 할수있는것들 모음.
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	
	public void dbExecuteUpdate(String query) { //얘로 다 하는거임
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "0000");
			st = con.createStatement();
			st.executeUpdate(query);
			con.close();
		} catch (SQLException e) {
		}
	}
	//글쓰기
	public void insertPost(String writer, String title, String content) {
		String query = "insert into board_post (title, wr_id, content) values ('" + title + "', '" + writer + "', '"
				+ content + "')";
		dbExecuteUpdate(query);
		query = "update members set post_count = post_count + 1 where id = '" + writer + "'";
		dbExecuteUpdate(query);
	}
	//댓글쓰기
	public void insertReply(String writer, String content) {
		String query = "insert into board_reply(re_pnum, re_writer, re_content) values ('" + GeneralBoard.postNum
				+ "', '" + writer + "', '" + content + "')";
		dbExecuteUpdate(query);
		query = "update board_post set re_count = re_count + 1 where post_num = " + GeneralBoard.postNum;
		dbExecuteUpdate(query);
	}
	//멤바 추가(가입)
	public void insertMembers(String id, String pw) {
		String query = "insert into members(id, pw) values ('" + id + "', '" + pw + "')";
		dbExecuteUpdate(query);
		Disp.infoPrint(" [ 🍒 회원가입 성공 🍒 ] " + id + " 님 환영합니다!");
	}
	//글지우기
	public void deletePost(int postNum) {
		DataGetInfo dgi = new DataGetInfo();
		if (dgi.findWrID().equals("비회원")) {
			String query = "delete from board_post where post_num =" + postNum;
			dbExecuteUpdate(query);
		} else {
			String wr_id = dgi.findWrID();
			String query = "update members set post_count = post_count - 1 where id = '" + wr_id + "'";
			dbExecuteUpdate(query);
			query = "delete from board_post where post_num =" + postNum;
			dbExecuteUpdate(query);
		}
	}
	//글수정
	public void editPost(String title, String content) {
		String query;
			if (title.equals("")) { //공백입력시.. 업데이트 하지 않음. 즉 이전내용 그대로!
				query = "update board_post set content='" + content + "' where post_num = " + GeneralBoard.postNum;
				if (content.equals("")) { //둘다 공백일경우
					Disp.infoPrint("수정사항이 없습니다.");
					Board.input = GeneralBoard.postNum + ""; //수정하고 해당 글로 돌아가기 위함.
					return;
				}
			} else if (content.equals("")) {
				query = "update board_post set title='" + title + "' where post_num = " + GeneralBoard.postNum;
			} else {
				query = "update board_post set title='" + title + "', content='" + content
						+ "' where post_num = " + GeneralBoard.postNum;
			}
			dbExecuteUpdate(query);
			Disp.infoPrint("수정했습니다.");
			Board.input = GeneralBoard.postNum + ""; //수정하고 해당 글로 돌아가기 위함.
	}
	//조회수 1 올리기(읽기에서 해당 글 들어갔을때 호출)
	public void updateHit() {
		String query;
		query = "update board_post set hit = hit + 1 where post_num =" + GeneralBoard.postNum;
		dbExecuteUpdate(query);
	}

	//하트 올리기
	public void updateLike() {
		String query;
		query = "update board_post set like_count = like_count + 1 where post_num =" + GeneralBoard.postNum;
			dbExecuteUpdate(query);
	}
	
	//글 수에 따라 회원 등급 올리기 
	public void updateMemberGrade() {
		String query = "update members set grade = '일반' where post_count < 5";
		dbExecuteUpdate(query);
		query = "update members set grade = '열심' where post_count >= 5 and post_count < 10";
		dbExecuteUpdate(query);
		query = "update members set grade = '최고' where post_count >= 10";
		dbExecuteUpdate(query);
	}
	
	public void updateLoginInfo() {
		updateMemberGrade();
		DataSelect ds = new DataSelect();
		if (Board.loginId.equals("")) {
			return;
		}
		String where = "where id = '" + Board.loginId + "'";
		Board.loginGrade = ds.dbExecuteQueryStr("grade", "members", where);
		return;
	}

}
