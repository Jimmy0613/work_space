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
int pNum = Integer.parseInt(request.getParameter("pNum"));
String writer = DataUpdate.loginNickname;
String content = request.getParameter("content");
content = content.replaceAll("\r\n","<br/>");
String query = "insert into reply(p_num,wr_id,re_content) values(" + pNum + ", '" + writer + "', '" + content + "')";
du.dbExecuteUpdate(query);
query = "update board_p set re_count = re_count + 1 where p_num = " + pNum;
du.dbExecuteUpdate(query);
out.println("<script>location.href='../read.jsp?num=" + pNum + "'</script>");

%>

</body>
</html>