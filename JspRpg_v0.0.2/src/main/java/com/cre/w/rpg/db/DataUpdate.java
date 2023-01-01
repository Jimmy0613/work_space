package com.cre.w.rpg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataUpdate {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		public void dbExecuteUpdate(String query) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "root", "0000");
				st = con.createStatement();
				st.executeUpdate(query);
				con.close();
			} catch (Exception e) {
			}
		}

		public void joinMember(String id, String pw, String m_name, String email) {
			String query = "insert into members(id, pw, m_name, e_mail) values('" + id + "', '" + pw + "', '" + m_name + "', '" + email + "')";
			dbExecuteUpdate(query);
		}

		public void sendSystemMsg(String msg) {
			String query = "insert into systemMessage(msg) value('" + msg + "');";
			dbExecuteUpdate(query);
		}
		
}
