<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cre.w.board.db.DataUpdate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>κ²μν v0.0.1</title>
</head>
<body>
	<%
	DataUpdate du = new DataUpdate();
			String memberInfo = du.loginInfo();
	%>
	π» κ²μν HOME π»
	<hr>
	β€π€β€ [ <a href="board/board.jsp">κ²μν</a> | 
	<% if(DataUpdate.loginId.equals("")){
		 %>
	  <a href="login.jsp"> λ‘κ·ΈμΈ </a> |	<a href="join.jsp"> νμκ°μ </a> ]
	<%
	} else{
		
	%>
	[ <a href="proc/logoutProc.jsp"> λ‘κ·Έμμ </a> ]
	<%
	}
	%>
	β€π€β€
	<hr>
	
	<%=memberInfo%>
	<hr>
	β€π€β€ [ π’ κ³΅μ§μ¬ν­ π’ ] β€π€β€
</body>
</html>