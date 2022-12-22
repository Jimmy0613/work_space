package com.cre.board.c.proc;

import com.cre.board.c.Board;
import com.cre.board.c.db.DataUpdate;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.Cw;
import com.cre.board.c.util.display.Disp;

public class ProcSignUp {
	public void signUp() {
		DataUpdate du = new DataUpdate();
		Disp.infoPrint("[ 회원가입 ]");
		String id = "";
		String pw;

		signup: while (true) {
			id: while (true) {
				id = Ci.r("아이디(4~8자)");
				if (id.length() > 8 || id.length() < 4) {
					Disp.infoPrint("<!> 글자 수를 확인해주세요.)");
				} else if (id.equals("비회원") || id.equals("운영자") || id.equals("매니저")) {
					Disp.infoPrint("사용할 수 없는 아이디입니다.");
				} else {
					break id;
				}
			}
			Cw.dot();
			Cw.wn("아이디:" + id);
			pw: while (true) {
				pw = Ci.r("비밀번호(4~12자)");
				if (pw.length() > 12 || pw.length() < 4) {
					Disp.infoPrint("<!> 글자 수를 확인해주세요.");
				} else
					break pw;
			}
			Cw.lineBar();
			Cw.dot();
			Cw.wn("아이디:" + id + " 비밀번호:" + pw);
			Cw.lineBar();
			Disp.infoPrint("가입하시겠습니까? [ o.가입 | x.취소 ]");
			Board.input = Ci.r();
			while (true) {
				switch (Board.input) {
				case "o":
					du.insertMembers(id, pw);
					break signup;
				case "x":
					Disp.infoPrint("<!> 취소되었습니다.");
					break signup;
				default:
					Board.input = Ci.r();
				}
			}
		}

	}

}
