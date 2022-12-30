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
	Member.loginId = "";
	Member.loginName = "";
		out.println("<script>location.href='../index.jsp'</script>");
	%>
</body>
</html>