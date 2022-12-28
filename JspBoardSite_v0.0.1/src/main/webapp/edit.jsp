<%@page import="com.cre.w.board.db.DataSelect"%>
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
DataSelect ds = new DataSelect();
String editNum = request.getParameter("num");

String where = "where p_num = " + editNum;
String wr_id = ds.dbExecuteQueryStr("wr_id", "board_p", where);
String title = ds.dbExecuteQueryStr("title", "board_p", where);
String content = ds.dbExecuteQueryStr("content", "board_p", where);

%>

<form action="proc/editProc.jsp">
<input name="num" type="hidden" value="<%=editNum %>">
	작성자: <%=wr_id %><br>
	제목: <input name = "title" value="<%=title%>"><br>
	<hr>
	<textarea name="content" rows="5" cols="50">
	<%=content%></textarea>
	<br>
	<input type="submit" value="수정하기">
</form>
</body>
</html>