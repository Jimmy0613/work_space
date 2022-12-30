<%@page import="com.cre.w.rpg.db.DataUpdate"%>
<%@page import="com.cre.w.rpg.db.DataSelect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
	String id = request.getParameter("id");
	String c_name = request.getParameter("c_name");
	String alert = "";
	boolean c_nameCheck = false;
	DataSelect ds = new DataSelect();
	DataUpdate du = new DataUpdate();
	String query = "";
	String where = "";

	//c_name체크(중복여부, 글자수)
	if (c_name != null) {
		if (c_name.length() >= 2 && c_name.length() <= 6) {
			where = "where c_name = '" + c_name + "'";
			int cnt = ds.dbExecuteQueryInt("count(*)", "characters", where);
			if (cnt > 0) {
		alert = "(이미 사용중)";
			} else {
		c_nameCheck = true;
			}
		} else {
			alert = alert + "(글자 수 확인)";
		}
	}

	if (c_nameCheck) {
		query = "insert into characters(c_name) value('" + c_name + "')";
		du.dbExecuteUpdate(query);
		int c_num = ds.dbExecuteQueryInt("c_num", "characters", where);
		where = "where id = '" + id + "'";
		int cnt = ds.dbExecuteQueryInt("count(m_char1)", "members", where);
		if (cnt == 0) {
			query = "update members set m_char1 = " + c_num + " where id = '" + id + "'";
			du.dbExecuteUpdate(query);
		} else {
			query = "update members set m_char2 = " + c_num + " where id = '" + id + "'";
			du.dbExecuteUpdate(query);
		}
		out.println("<script>alert('캐릭터를 만들었습니다.')</script>");
		out.println("<script>location.href='../character.jsp'</script>");
	} else {
		out.println("<script>alert('사용할 수 없는 이름입니다. " + alert + "')</script>");
		out.println("<script>location.href='../character.jsp'</script>");
	}
	%>
</body>
</html>