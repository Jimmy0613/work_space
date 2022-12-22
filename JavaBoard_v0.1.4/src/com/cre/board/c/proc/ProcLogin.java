package com.cre.board.c.proc;

import com.cre.board.c.Board;
import com.cre.board.c.db.DataGetInfo;
import com.cre.board.c.db.DataSelect;
import com.cre.board.c.db.DataUpdate;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.Cw;
import com.cre.board.c.util.display.Disp;

public class ProcLogin {
	DataSelect ds = new DataSelect();
	DataUpdate du = new DataUpdate();
	DataGetInfo dgi = new DataGetInfo();
	public void login() {
		String id = "";
		String pw = "";

		Disp.infoPrint("[ 로그인 ] x.뒤로");
		login: while (true) {
			if (Board.input.equals("x")) {
				break login;
			}
			id = Ci.r("아이디");
			pw = Ci.r("비밀번호");
			login(id, pw);
			Disp.spaceln(5);

		}
	}
	
	public void login(String id, String pw) {
		int cnt = 0;
		String where = "where id = '" + id + "'"; //우선 아이디 있는지 확인
		cnt = dgi.getCount("members", where);
		if (cnt == 0) {
			Cw.wn("존재하지 않는 아이디입니다.");
			Board.input = "x";
			return;
		} else { //아디 비번 일치 확인
			String user_pw = ds.dbExecuteQueryStr("pw", "members", where);
			String grade = ds.dbExecuteQueryStr("grade", "members", where);
			if (pw.equals(user_pw)) {
				du.updateMemberGrade();
				Disp.infoPrint(" [ 🍒 로그인 성공 🍒 ] " + id + " 님 안녕하세요!");
				Board.loginId = id;
				Board.loginGrade = grade;
				Board.input = "x";
			} else {
				Disp.infoPrint("<!> 비밀번호가 일치하지 않습니다.");
				Board.input = "x";
				return;
			}
		}

	}

}
