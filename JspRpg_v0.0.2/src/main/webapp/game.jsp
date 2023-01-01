<%@page import="com.cre.w.rpg.game.Charac"%>
<%@page import="com.cre.w.rpg.db.DataUpdate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cre.w.rpg.db.Member"%>
<%@page import="com.cre.w.rpg.game.Map"%>
<%@page import="com.cre.w.rpg.db.DataSelect"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
/* CSS/JS 파일 캐시 방지 */
String styleCss = application.getRealPath("/css/common.css");
File style = new File(styleCss);
Date lastModifiedStyle = new Date(style.lastModified());
SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmssSSS");
%>
<link rel="stylesheet"
	href="css/common.css?ver=<%=fmt.format(lastModifiedStyle)%>">
<link rel="stylesheet"
	href="css/map.css?ver=<%=fmt.format(lastModifiedStyle)%>">
</head>
<body>

	<%
	Member m = new Member();
	Charac p = new Charac();
	DataSelect ds = new DataSelect();
	DataUpdate du = new DataUpdate();
	Map map = new Map();
	Map.m_id = Integer.parseInt(request.getParameter("m_id"));
	String screen = "map/m_" + Map.m_id + ".jsp";
	Member.playerC = Integer.parseInt(request.getParameter("c_num"));
	map.loadMap();
	p.loadCharacter();
	String mode = request.getParameter("mode");
	Charac.turnCount++;
	String msg = "";
	String where = "";
	ArrayList<String> msgs = new ArrayList<>();;
	switch (mode) {
		case "start" :
			Charac.turnCount = 0;
			du.dbExecuteUpdate("delete from systemMessage;");
			msg = "[ " + Charac.turnCount + " ] 환영합니다!";
			du.sendSystemMsg(msg);
			where = "order by sm_num desc limit 0, 10";
			msgs = ds.dbExecuteQueryStrArr("msg", "systemMessage", where);
			break;
		case "move" :
			String m_name = Map.m_name;
			msg = "[ " + Charac.turnCount + " ] " + m_name + "(으)로 이동했습니다.";
			du.sendSystemMsg(msg);
			where = "order by sm_num desc limit 0, 10";
			msgs = ds.dbExecuteQueryStrArr("msg", "systemMessage", where);
			break;
	}
	%>
	<div id="gamebox">
		<div id="screen">
			<div id="t">
				<b id="title">&nbsp; jsp_rpg_v0.0.1</b>
				<hr>
			</div>
			<div id="n">
				<%
				if (Map.north_map != 0) {
				%>
				<button
					onclick="location.href='game.jsp?m_id=<%=Map.north_map%>&c_num=<%=Member.playerC%>&mode=move'">이동</button>
				&nbsp;
				<%
				out.println(map.getName(Map.north_map));
				} else {
				%>
				이곳은 막혀있다.
				<%
				}
				%>

			</div>
			<div id="w">
				<%
				if (Map.west_map != 0) {
					out.println(map.getName(Map.west_map));
				%>
				<br>
				<button
					onclick="location.href='m_<%=Map.west_map%>.jsp?m_id=<%=Map.west_map%>&c_num=<%=Member.playerC%>&mode=move'">이동</button>
				<%
				} else {
				%>
				이곳은<br> 막혀있다.
				<%
				}
				%>
			</div>
			<div id="c">
				<jsp:include page="<%=screen%>"></jsp:include>

			</div>
			<div id="e">

				<%
				if (Map.east_map != 0) {
				%>
				<button
					onclick="location.href='m_<%=Map.east_map%>.jsp?m_id=<%=Map.east_map%>&c_num=<%=Member.playerC%>&mode=move'">이동</button>
				<%
				out.println(map.getName(Map.east_map));
				} else {
				%>
				이곳은 <br>막혀있다.
				<%
				}
				%>

			</div>
			<div id="s">
				<%
				if (Map.south_map != 0) {
				%>
				<button
					onclick="location.href='game.jsp?m_id=<%=Map.south_map%>&c_num=<%=Member.playerC%>&mode=move'">이동</button>
				&nbsp;
				<%
				out.println(map.getName(Map.south_map));
				} else {
				%>
				이곳은 막혀있다.
				<%
				}
				%>
			</div>
		</div>
		<div id="system">
			<div id="s_banner_top">
				<div id="menu">
					<div id="menu_i">
						<a href="proc/logoutProc.jsp"><img src="img/logout.png"
							id="icon"></a>
					</div>
					<div id="menu_t">
						<b>&nbsp;&nbsp;(로그아웃)</b>
					</div>
				</div>
				<div id="c_mode">
					&nbsp;&nbsp;
					<%=Charac.info%></div>
			</div>

			<script>
				function showPopup() {
					window.open("log.jsp", "지난 로그",
							"width=500, height=300, top=200, left=100");
				}
			</script>
			<div id="s_middle">
				<b><%=map.getInfo(Map.m_id)%></b>
				<button onclick="showPopup();">지난 기록 보기</button>
				<div id="msgbox">
					<%
					if (msgs.size() != 0) {
						for(int i = msgs.size()-1; i>=0; i--){
							out.println(msgs.get(i));%>
						<br><%}
					}
					%>
				</div>
			</div>
			<div id="s_banner_bot">
				&nbsp;
				<%=m.loginInfo()%>
			</div>
		</div>

	</div>
</body>
</html>