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
	map.loadMap();
	Map.m_id = Integer.parseInt(request.getParameter("m_id"));
	String mode = request.getParameter("mode");
	%>
	<div id="t">
		<b id="title">&nbsp; jsp_rpg_v0.0.1</b>
		<hr>
	</div>
	<div id="n">
		<%
		if (Charac.map >= 1) {
		%>
		<button onclick="location.href='../game.jsp?m_id=2&mode=move'">이동</button>
		&nbsp;
		<%
		out.println(map.getName(Map.north_map));
		}
		%>

	</div>
	<div id="w"></div>
	<!---------------------------------------------------스크린 --------------------------------------------------->
	<div id="c">
		<%
		String msg = "";
		switch (mode) {
		case "move":
			map.move();
		case "start":
		case "normal":
		%>
		<div id="bed">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='../game.jsp?m_id=1&mode=action1'">잠자기</button>
			<img src="img/bed.jpg" id="bedimg">
		</div>
		<div id="player_1">
			<img src="img/humannormal.jpg" id="playerimg">
		</div>
		<%
		break;
		case "action1":
			if (Charac.power == Charac.powerFull) {
				du.sendSystemMsg(Charac.name + " \"지금은 잘 필요가 없는 것 같은데?\"");
				if (Charac.story < 1) {
			Charac.story = 1;
			Charac.map = 1;
			du.sendSystemMsg("🎉 새로운 이야기를 완료했습니다. ");
			du.sendSystemMsg("💡 지난 이야기 보기를 통해 완료한 이야기 목록을 볼 수 있습니다.");
			du.sendSystemMsg("🎉 새로운 지역이 열렸습니다. [ 복도 ]");
		%>
		<jsp:forward page="../game.jsp">
			<jsp:param value="normal" name="mode" />
			<jsp:param value="1" name="m_id" />
		</jsp:forward>
		<%
		}
		%>
		<div id="bed">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='../game.jsp?m_id=1&mode=action1'">잠자기</button>
			<img src="img/bed.jpg" id="bedimg">
		</div>
		<div id="player_1">
			<img src="img/humannormal.jpg" id="playerimg">
		</div>
		<%
		} else {
		l.turn();
		du.sendSystemMsg("[ " + Log.turnCount + " ] 침대에 누웠습니다..");
		%>
		<div id="bed">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='../game.jsp?m_id=1&mode=action2'">일어나기</button>
			<img src="img/sleeping.jpg" id="bedimg">
		</div>
		<%
		}
		break;
		case "action2":
		l.turn();
		Charac.power = Charac.powerFull;
		c.updateCharacter();
		du.sendSystemMsg("[ " + Log.turnCount + " ] 힘을 되찾았습니다.");
		if (Charac.story < 3) {
		Charac.story = 3;
		Charac.map = 2;
		du.sendSystemMsg("🎉 새로운 이야기를 완료했습니다. ");
		du.sendSystemMsg("🎉 새로운 지역이 열렸습니다. [ 주방 ]");
		du.sendSystemMsg("💡 [방으로] 아이콘을 누르면 즉시 [ 나의 방 ]으로 이동할 수 있습니다.");
		du.sendSystemMsg("💡 [지도] 아이콘을 누르면 열린 지역을 확인할 수 있습니다.");
		}
		%>
		<jsp:forward page="../game.jsp">
			<jsp:param value="action3" name="mode" />
			<jsp:param value="1" name="m_id" />
		</jsp:forward>
		<%
		case "action3":
		%>
		<div id="bed">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='../game.jsp?m_id=1&mode=action1'">잠자기</button>
			<img src="img/bed.jpg" id="bedimg">
		</div>
		<div id="player_1">
			<img src="img/humanPower.png" id="playerimg">
		</div>
		<%
		}
		%>
	</div>
	<!----------------------------------------------------------------------------------------------------------------->
	<div id="e"></div>
	<div id="s"></div>
</body>
</html>