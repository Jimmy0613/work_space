<%@page import="com.cre.w.board.db.DataUpdate"%>
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
String writer = DataUpdate.loginNickname;
String title = request.getParameter("title");
String content = request.getParameter("content");
content = content.replaceAll("\r\n", "<br/>");
String query = "insert into board_p(wr_id,title,content) values('" + writer + "', '" + title + "', '" + content + "')";
du.dbExecuteUpdate(query);
out.println("<script>location.href = '../board/b_general.jsp?op=1'</script>");


%>
</body>
</html>