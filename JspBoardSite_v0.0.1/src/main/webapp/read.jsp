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
<a href="index.jsp">ν</a> | <a href="board/board.jsp">κ²μν</a>
<hr>
π» β€ μμ κ²μν β€ π»
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
[μμ±μ:<%=wr_id %>| <%=date %>] μ‘°νμ <%=hit %> <hr>
<br><%=content %>
<br><br>
<%
if(wr_id.equals(DataUpdate.loginNickname)){
%>
[<a href="edit.jsp?num=<%=readNum %>">μμ </a>|μ­μ ]
<%
}
%>
<hr>
<%=re_count %>κ°μ λκΈμ΄ μμ΅λλ€.<br>
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
<input name="content"> <input type="submit" value="λ±λ‘νκΈ°">
</form>
<%
} else {
%>
<form action="login.jsp">
<input name="content" placeholder="λκΈμ μμ±νμλ €λ©΄ λ‘κ·ΈμΈνμΈμ.">
<input type="submit" value="λ±λ‘νκΈ°">
</form>
<%
}
%>
<a href="board/b_general.jsp?op=<%=Page.currentPage%>">λͺ©λ‘</a>
</body>
</html>