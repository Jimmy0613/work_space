package com.cre.board.db;

import java.sql.SQLException;

import com.cre.board.Board;
import com.cre.board.display.Disp;
import com.cre.board.proc.ProcGeneral;
import com.cre.util.Cw;

public class DataUpdate {
	Database db = new Database();

	public void dbDel(int postNum) {
		db.dbBoard();
		try {
			db.st.executeUpdate("delete from board_post where post_num =" + postNum);

		} catch (SQLException e) {
			Cw.wn("SQLException: " + e.getMessage());
			Cw.wn("SQLState: " + e.getSQLState());
		}
	}

	public void dbEdit(String title, String content) {
		db.dbBoard();
		try {
			if (title.equals("")) {
				db.st.executeUpdate(
						"update board_post set content='" + content + "' where post_num = " + ProcGeneral.postNum);
			} else if (content.equals("")) {
				db.st.executeUpdate("update board_post set title='" + title + "' where post_num = " + ProcGeneral.postNum);
			} else {
				db.st.executeUpdate("update board_post set title='" + title + "', content='" + content
						+ "' where post_num = " + ProcGeneral.postNum);
			}
			Disp.menuPrint("수정했습니다.");
			Board.input = ProcGeneral.postNum + "";
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbHit(int postNum) {
		db.dbBoard();
		try {
			db.st.executeUpdate("update board_post set hit = hit + 1 where post_num =" + postNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
