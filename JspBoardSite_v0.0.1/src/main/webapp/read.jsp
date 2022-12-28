<%@page import="com.cre.w.board.Page"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cre.w.board.db.DataGetInfo"%>
<%@page import="com.cre.w.board.db.DataUpdate"%>
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
String readNum = request.getParameter("num");
DataSelect ds = new DataSelect();
DataUpdate du = new DataUpdate();
DataGetInfo dgi = new DataGetInfo();

String where = "where p_num = " + readNum;
%>
<a href="index.jsp">홈</a> | <a href="board/board.jsp">게시판</a>
<hr>
👻 ❤ 자유게시판 ❤ 👻
<hr>

<%=du.loginInfo()%>
<hr>
<%
du.updateHit(readNum);
String wr_id = ds.dbExecuteQueryStr("wr_id", "board_p", where);
String title = ds.dbExecuteQueryStr("title", "board_p", where);
String content = ds.dbExecuteQueryStr("content", "board_p", where);
String date = ds.dbExecuteQueryStr("p_date", "board_p", where);
int re_count = ds.dbExecuteQueryInt("re_count", "board_p", where);
int hit = ds.dbExecuteQueryInt("hit", "board_p", where);
%>
<%=readNum %> | [<%=title %>]<hr>
[작성자:<%=wr_id %>| <%=date %>] 조회수 <%=hit %> <hr>
<br><%=content %>
<br><br>
<%
if(wr_id.equals(DataUpdate.loginNickname)){
%>
[<a href="edit.jsp?num=<%=readNum %>">수정</a>|삭제]
<%
}
%>
<hr>
<%=re_count %>개의 댓글이 있습니다.<br>
<hr>

<% 
if(re_count > 0){
where = "where p_num = " + readNum;
ArrayList<String> re_writer = ds.dbExecuteQueryStrArr("wr_id", "reply", where);
ArrayList<String> re_content = ds.dbExecuteQueryStrArr("re_content", "reply", where);
ArrayList<String> re_date = ds.dbExecuteQueryStrArr("re_date", "reply", where);
	String re_w;
	String re_c;
	String re_d;

if(re_writer.size() != 0){
	for(int i=0; i<re_writer.size(); i++){
		re_w = re_writer.get(i);
		re_c = re_content.get(i);
		re_d = re_date.get(i);
%>
<%=re_w %>: <%=re_c %> (<%=re_d %>)
<hr>
<%
	}
	
}
}
%>

<%
if(!DataUpdate.loginId.equals("")){
%>
<form action="proc/replyProc.jsp">
<input type="hidden" name="pNum" value="<%=readNum %>">
<input name="content"> <input type="submit" value="등록하기">
</form>
<%
} else {
%>
<form action="login.jsp">
<input name="content" placeholder="댓글을 작성하시려면 로그인하세요.">
<input type="submit" value="등록하기">
</form>
<%
}
%>
<a href="board/b_general.jsp?op=<%=Page.currentPage%>">목록</a>
</body>
</html>