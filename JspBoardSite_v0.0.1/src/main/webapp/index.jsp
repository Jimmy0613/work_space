<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cre.w.board.db.DataUpdate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 v0.0.1</title>
</head>
<body>
	<%
	DataUpdate du = new DataUpdate();
		String memberInfo = du.updateTopMenu();
	%>
	👻 게시판 HOME 👻
	<hr>
	❤🖤❤ [ <a href="board.jsp">게시판</a> | 
	<% if(DataUpdate.loginId.equals("")){
		 %>
	  <a href="login.jsp"> 로그인 </a> |	<a href="joinMem.jsp"> 회원가입 </a> ]
	<%
	} else{
		
	%>
	[ <a href="logoutProc.jsp"> 로그아웃 </a> ]
	<%
	}
	%>
	❤🖤❤
	<hr>
	[ 🍒 회원정보 🍒 ]
	<%=memberInfo%>
	<hr>
	❤🖤❤ [ 📢 공지사항 📢 ] ❤🖤❤
</body>
</html>