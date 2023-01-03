<%@page import="com.cre.w.rpg.db.Member"%>
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
	Member m = new Member();
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String alert = "";
	boolean idCheck = false;
	boolean pwCheck = false;
	//id 체크
	DataSelect ds = new DataSelect();
	String where = "";
	if (id != null) {
		where = "where id = '" + id + "'";
		int cnt = -1;
		cnt = ds.dbExecuteQueryInt("count(*)", "members", where);
		if (cnt > 0) {
			idCheck = true;
		} else {
			alert = alert + "(존재하지 않는 아이디) ";
		}
	}

	//pw체크(correct pw)
	if (pw != null) {
		where = "where id = '" + id + "'";
		String c_pw = ds.dbExecuteQueryStr("pw", "members", where);
		if (pw.equals(c_pw)) {
			pwCheck = true;
		} else {
			alert = alert + "(비밀번호 불일치)";
		}
	}

	if (idCheck && pwCheck) {
		Member.loginId = id;
		Member.loginName = ds.dbExecuteQueryStr("m_name", "members", where);
		if(m.isChar("m_char1")){
		Member.loginC1 = ds.dbExecuteQueryInt("m_char1", "members", where);
		}
		if(m.isChar("m_char2")){
		Member.loginC2 = ds.dbExecuteQueryInt("m_char2", "members", where);
		}
		out.println("<script>location.href='../character.jsp'</script>");
	} else {
		out.println("<script>alert('로그인 실패 " + alert + "')</script>");
		out.println("<script>location.href='../login.jsp'</script>");
	}
	%>
</body>
</html>