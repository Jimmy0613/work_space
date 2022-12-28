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
String editNum = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");
content = content.replaceAll("\r\n", "<br/>");
String query = "update board_p set title='"+title+"', content='"+content+"' where p_num=" + editNum;
du.dbExecuteUpdate(query);
out.println("<script>location.href = '../read.jsp?num=" + editNum + "'</script>");


%>
</body>
</html>