<%@page import="com.cre.w.board.db.DataUpdate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<%
DataUpdate du = new DataUpdate();
if(DataUpdate.loginId.equals("")){
	out.println("<script>alert('먼저 로그인해주세요.');</script>");
	out.println("<script>location.href = 'login.jsp'</script>");
} else {
	%>
	<a href="index.jsp">홈</a> | <a href="board/board.jsp">게시판</a>
<hr>
👻 ❤ 자유게시판 글쓰기 ❤ 👻
<hr>
<%=du.loginInfo()%>
<hr>
	<form action="proc/writeProc.jsp">
	작성자: <%=DataUpdate.loginNickname %><br>
	제목: <input name = "title"><br>
	<hr>
	<textarea name="content" rows="5" cols="50">
	</textarea>
	<br>
	<input type="submit" value="글쓰기">
	</form>
	
	
	<%
}
%>

</body>
</html>