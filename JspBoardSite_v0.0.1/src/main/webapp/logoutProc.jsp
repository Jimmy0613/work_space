<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cre.w.board.db.DataUpdate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	DataUpdate du = new DataUpdate();
	DataUpdate.loginId = "";
	out.println("<script>alert('로그아웃했습니다.')</script>");
	out.println("<script>location.href = 'index.jsp'</script>");
	%>
</body>
</html>