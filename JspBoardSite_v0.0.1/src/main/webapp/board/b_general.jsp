<%@page import="com.cre.w.board.db.DataSelect"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cre.w.board.util.Disp"%>
<%@page import="com.cre.w.board.Page"%>
<%@page import="com.cre.w.board.db.DataUpdate"%>
<%@page import="com.cre.w.board.db.DataGetInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="../index.jsp">ν</a> |
	<a href="board.jsp">κ²μν</a>
	<hr>
	<%
	Page p = new Page();
	Disp d = new Disp();
	int op = Integer.parseInt(request.getParameter("op"));
	Page.currentPage = op;
	Page.startIndex = (op - 1) * 5;
	p.getPages();
	DataUpdate du = new DataUpdate();
	DataGetInfo dgi = new DataGetInfo();
	DataSelect ds = new DataSelect();
	int p_num;
	String writer;
	String t;
	int r;
	int h;
	int cnt = 0;
	cnt = dgi.getCount("board_p","");
	if (cnt < 1) {
	%>
	π» β€ μμ κ²μν β€ π» [κ²μκΈ 0κ°]
	<hr>
	<%=du.loginInfo()%>
	<hr>
	λ²νΈ | κΈμ΄μ΄ | μ λͺ© | μ‘°νμ
	<hr>
	μ¬λΌμ¨ κΈμ΄ μμ΅λλ€.
	<hr>
	<%
	} else {
	String where = "order by p_num desc limit " + Page.startIndex + ", " + Page.PER_PAGE;
	%>
	π» β€ μμ κ²μν β€ π» [κ²μκΈ
	<%=cnt%>κ°]
	<hr>
	<%=du.loginInfo()%>
	<hr>
	λ²νΈ | κΈμ΄μ΄ | μ λͺ© | μ‘°νμ
	<hr>
	<%
	%>
	<%
	ArrayList<Integer> postNum = ds.dbExecuteQueryIntArr("p_num", "board_p", where);
	ArrayList<String> wr_id = ds.dbExecuteQueryStrArr("wr_id", "board_p", where);
	ArrayList<String> title = ds.dbExecuteQueryStrArr("title", "board_p", where);
	ArrayList<Integer> re_count = ds.dbExecuteQueryIntArr("re_count", "board_p", where);
	ArrayList<Integer> hit = ds.dbExecuteQueryIntArr("hit", "board_p", where);
	if (re_count.size() != 0) {
		for (int i = 0; i < re_count.size(); i++) {
			p_num = postNum.get(i);
			writer = wr_id.get(i);
			t = title.get(i);
			r = re_count.get(i);
			h = hit.get(i);
			if (r == 0) {
	%>
	<%=p_num%> | <%=writer%> | <a href="../read.jsp?num=<%=p_num%>"><%=t%></a> | <%=h%>
	<hr>
	<%
	} else {
	%>
	<%=p_num%> | <%=writer%> | <a href="../read.jsp?num=<%=p_num%>"><%=t%> (<%=r%>)</a> | <%=h%>
	<hr>
	<%
	}
	}
	}
	}
	%>
	νμ΄μ§ [
	<%
	for (int i = 1; i <= Page.lastPageG; i++) {
		if (i == Page.currentPage) {
	%>
	<a href="b_general.jsp?op=<%=i%>">(<%=i%>)
	</a>
	<%
	} else {
	%>
	<a href="b_general.jsp?op=<%=i%>"><%= i %></a>
	<%
	}
	}
	%>
	]
	<a href="../write.jsp">κΈμ°κΈ°</a>

</body>
</html>