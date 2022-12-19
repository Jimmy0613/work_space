package com.cre.board.db;

import java.sql.SQLException;
import java.time.LocalDate;

import com.cre.board.proc.ProcGeneral;

public class DataInsert {

	Database db = new Database();
	
	public void dbPost(String writer, String title, String content) {
		db.dbBoard();
		LocalDate now = LocalDate.now();
		String date = now.toString();
		try {
			if (title.equals("") && writer.equals("")) {
				db.st.executeUpdate(
						"insert into board_post (content, date) values ('" + content + "', '" + date + "');");
			} else if (writer.equals("")) {
				db.st.executeUpdate("insert into board_post (title, content, date) values ('" + title + "', '"
						+ content + "', '" + date + "');");
			} else if (title.equals("")) {
				db.st.executeUpdate("insert into board_post (wr_id, content, date) values ('" + writer + "', '"
						+ content + "', '" + date + "');");
			} else {
				db.st.executeUpdate("insert into board_post (title, wr_id, content, date) values ('" + title
						+ "', '" + writer + "', '" + content + "', '" + date + "');");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dbReply(String writer, String content) {
		db.dbBoard();
		try {
			if (writer.equals("")) {
				db.st.executeUpdate("insert into board_reply(re_pnum, re_content) values ('" + ProcGeneral.postNum
						+ "', '" + content + "');");
			} else {
				db.st.executeUpdate("insert into board_reply(re_pnum, re_writer, re_content) values ('"
						+ ProcGeneral.postNum + "', '" + writer + ":', '" + content + "');");
			}
			db.st.executeUpdate(
					"update board_post set re_count = re_count + 1 where post_num = " + ProcGeneral.postNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
