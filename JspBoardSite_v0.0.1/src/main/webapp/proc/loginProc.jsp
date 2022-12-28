<%@page import="com.cre.w.board.db.DataUpdate"%>
<%@ page import="com.cre.w.board.db.DataGetInfo"%>
<%@ page import="com.cre.w.board.db.DataSelect"%>
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


	DataGetInfo dgi = new DataGetInfo();
	DataSelect ds = new DataSelect();
	DataUpdate du = new DataUpdate();
	String input_id = request.getParameter("id");
	String input_pw = request.getParameter("pw");
	int cnt = 0;
	String where = "where id = '" + input_id +"'";
	cnt = dgi.getCount("members", where);
	if (cnt < 1) {
		out.println("<script>alert('존재하지 않는 아이디입니다.');</script>");
		out.println("<script>location.href = '../login.jsp'</script>");
	} else { //아디 비번 일치 확인
		String user_id = ds.dbExecuteQueryStr("id","members",where);
		String user_pw = ds.dbExecuteQueryStr("pw", "members", where);
		String user_grade = ds.dbExecuteQueryStr("grade", "members", where);
		String user_nickname = ds.dbExecuteQueryStr("nickname", "members", where);
		if (input_pw.equals(user_pw)) {
			DataUpdate.loginId = user_id;
			DataUpdate.loginGrade = user_grade;
			DataUpdate.loginNickname = user_nickname;
			out.println("<script>alert('로그인했습니다.');</script>");
			out.println("<script>location.href = '../index.jsp'</script>");
		} else {
			out.println("<script>alert('비밀번호가 일치하지 않습니다.');</script>");
			out.println("<script>location.href = '../login.jsp'</script>");
		}
	}
	%>
</body>
</html>