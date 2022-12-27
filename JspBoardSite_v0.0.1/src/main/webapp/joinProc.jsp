<%@ page import="com.cre.w.board.db.DataUpdate" %>
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
	DataUpdate du = new DataUpdate();
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String nickname = request.getParameter("nickname");
	du.joinMember(id, pw, nickname);
	response.sendRedirect("index.jsp");
	%>
</body>
</html>