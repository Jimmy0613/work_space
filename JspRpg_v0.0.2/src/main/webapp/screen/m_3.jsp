<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@page import="com.cre.w.rpg.db.Member"%>
<%@page import="com.cre.w.rpg.game.Map"%>
<%@page import="com.cre.w.rpg.game.Log"%>
<%@page import="com.cre.w.rpg.db.DataUpdate"%>
<%@page import="com.cre.w.rpg.game.Charac"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
String styleCss = application.getRealPath("/css/common.css");
File style = new File(styleCss);
Date lastModifiedStyle = new Date(style.lastModified());
SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmssSSS");
%>
<link rel="stylesheet"
	href="../css/common.css?ver=<%=fmt.format(lastModifiedStyle)%>">
<link rel="stylesheet"
	href="../css/map.css?ver=<%=fmt.format(lastModifiedStyle)%>">
<title>Insert title here</title>
</head>
<body>
	<%
	Map map = new Map();
	Charac c = new Charac();
	DataUpdate du = new DataUpdate();
	Log l = new Log();
	Map.m_id = Integer.parseInt(request.getParameter("m_id"));
	String mode = request.getParameter("mode");
	String msg = "";
	%>
	<div id="t">
		<b id="title">&nbsp; jsp_rpg_v0.0.1</b>
		<hr>
	</div>
	<div id="n"></div>
	<div id="w"></div>
	<!------------------스크린 ------------------>
	<div id="c">
		<%
		switch (mode) {
		case "move":
			map.move();
		case "normal":
		%>
		<div id="fridge">
			<img src="img/fridge.png" id="fridgeimg">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='../game.jsp?m_id=3&mode=action1'">냉장고
				열기</button>
		</div>
		<div id="player_3">
			<img src="img/humannormal.jpg" id="playerimg">
		</div>
		<%
		break;
		case "action1":
			if (Charac.story < 4) {
				Charac.story = 4;
				du.sendSystemMsg("🎉 새로운 이야기를 완료했습니다. ");
				du.sendSystemMsg("💡 냉장고에는 음식 아이템을 넣을 수 있습니다.");
			}
		%>
		<div id="fridgeopen">
			<p>
				<button onclick="location.href='../game.jsp?m_id=3&mode=normal'">냉장고
					닫기</button>
			</p>
			<div id="fridgeinside">
				<div id="fridgecontent">1</div>
				<div id="fridgecontent">2</div>
				<div id="fridgecontent">3</div>
				<div id="fridgecontent">4</div>
				<div id="fridgecontent">5</div>
				<div id="fridgecontent">6</div>
				<div id="fridgecontent">7</div>
				<div id="fridgecontent">8</div>
				<div id="fridgecontent">9</div>
				<div id="fridgecontent">10</div>
				<div id="fridgecontent">11</div>
				<div id="fridgecontent">12</div>
			</div>
		</div>

		<%
		break;
		}
		%>
	</div>
	<!------------------스크린 ------------------>
	<div id="e">
		<%
		if (Charac.map >= 2 && Charac.story >= 4) {
		%>
		<button onclick="location.href='game.jsp?m_id=2&mode=move'">이동</button>
		<%
		out.println(map.getName(Map.east_map));
		}
		%>
	</div>
	<div id="s"></div>
</body>
</html>