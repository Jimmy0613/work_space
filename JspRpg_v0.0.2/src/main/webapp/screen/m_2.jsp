<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@page import="com.cre.w.rpg.db.Member"%>
<%@page import="com.cre.w.rpg.game.Log"%>
<%@page import="com.cre.w.rpg.db.DataUpdate"%>
<%@page import="com.cre.w.rpg.game.Charac"%>
<%@page import="com.cre.w.rpg.game.Map"%>
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
	Charac c = new Charac();
	DataUpdate du = new DataUpdate();
	Map map = new Map();
	Map.m_id = Integer.parseInt(request.getParameter("m_id"));
	String mode = request.getParameter("mode");
	String msg = "";
	Log l = new Log();
	%>
	<div id="t">
		<b id="title">&nbsp; jsp_rpg_v0.0.1</b>
		<hr>
	</div>
	<div id="n"></div>
	<div id="w">
		<%
		if (Charac.map >= 2) {
			out.println(map.getName(Map.west_map));
		%>
		<br>
		<button onclick="location.href='game.jsp?m_id=3&mode=move'">이동</button>
		<%
		}
		%>
	</div>
	<div id="c">
		<!------------------스크린 ------------------>
		<%
		switch (mode) {
		case "move":
			if (Charac.story < 2) {
				map.move();
				du.sendSystemMsg(Charac.name + " \"으악 쥐다!\"");
				l.turn();
				du.sendSystemMsg("[ " + Log.turnCount + " ] 쥐를 보고 놀라 힘이 빠졌습니다. (힘 -2)");
				Charac.power -= 2;
				c.updateCharacter();
		%>
		<jsp:forward page="../game.jsp">
			<jsp:param value="action1" name="mode" />
			<jsp:param value="<%=2%>" name="m_id" />
		</jsp:forward>
		<%
		} else {
		map.move();
		}
		case "normal":
		%>
		<div id="player_2">
			<img src="img/humannormal.jpg" id="playerimg">
		</div>
		<%
		break;
		case "action1":
		%><div id="player_2">
			<img src="img/humansurprised.jpg" id="playerimg">
		</div>
		<div id="mice_1">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='../game.jsp?m_id=2&mode=action2'">쫓아내기</button>
			<img src="img/mice.png" id="miceimg">
		</div>
		<%
		break;
		case "action2":
			l.turn();
			Charac.power -= 1;
			du.sendSystemMsg("[ " + Log.turnCount + " ] 쥐가 도망갔습니다. (힘 -1)");
			Charac.story = 2;
			du.sendSystemMsg("🎉 새로운 이야기를 완료했습니다. ");
			du.sendSystemMsg("💡 침대에서 자면 힘을 회복할 수 있습니다.");
		%>
		<jsp:forward page="../game.jsp">
			<jsp:param value="normal" name="mode" />
			<jsp:param value="2" name="m_id" />
		</jsp:forward>
		<%
		}
		%>
	</div>
	<!---------------------------------------------------------------------------------------------------------------------------->
	<div id="e"></div>
	<div id="s">
	<%
	if(Charac.story>=2){
	out.println(map.getName(Map.south_map));%>
		<br>
		<button onclick="location.href='game.jsp?m_id=1&mode=move'">이동</button>
	<%}%>
	</div>
</body>
</html>