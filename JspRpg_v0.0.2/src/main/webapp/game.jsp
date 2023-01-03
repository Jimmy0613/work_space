<%@page import="com.cre.w.rpg.game.Log"%>
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
	Charac c = new Charac();
	Map map = new Map();
	Log l = new Log();
	DataSelect ds = new DataSelect();
	DataUpdate du = new DataUpdate();

	Map.m_id = Integer.parseInt(request.getParameter("m_id"));
	map.loadMap();
	String map_jsp = "screen/m_" + Map.m_id + ".jsp";
	String mode = request.getParameter("mode");
	%>
	<div id="gamebox">
		<div id="screen">
			<jsp:include page="<%=map_jsp%>">
				<jsp:param value="<%=mode%>" name="mode" />
				<jsp:param value="<%=Map.m_id%>" name="m_id" />
			</jsp:include>
		</div>
		<div id="system">
			<div id="s_banner_top">
				<div id="menu">
					<div id="menu_i">
						<a href="proc/logoutProc.jsp"><img src="img/logout.png"
							id="icon"></a> <a href="character.jsp"><img
							src="img/charac.png" id="icon"></a>
					</div>
					<div id="menu_t">
						<b>&nbsp;&nbsp;(로그아웃)</b> <b>&nbsp;&nbsp;(캐릭터선택)</b>
					</div>
				</div>
				<%
				c.updateCharacter();
				c.loadCharacter();
				%>
				<div id="c_mode">
					<div>
						&nbsp;&nbsp;<%=Charac.info%></div>
					<div id="exp">
						<b>경험치 [ <%=Charac.exp%> / <%=Charac.max_exp%> ]
						</b>
					</div>
				</div>
			</div>

			<script>
				function showLog() {
					window.open("log.jsp", "지난 로그",
							"width=500, height=300, top=200, left=100");
				}
				function showStory() {
					window.open("story.jsp", "지난 이야기",
							"width=500, height=300, top=200, left=100");
				}
			</script>
			<div id="s_middle_game">
				<div id="map_info">
					<%
					map.loadMap();
					%>
					현재 위치:
					<%=map.getInfo()%>
				</div>
				<div id="menu_right_t">메뉴</div>
				<div id="msgbox">
					<jsp:include page="logTen.jsp">
						<jsp:param value="" name="" />
					</jsp:include>
				</div>
				<div id="menu_right">
					<%
					if (Charac.story >= 3) {
					%>
					<div id="home">
						<a href="game.jsp?m_id=1&mode=move"><img src="img/home.png"
							id="homeimg"></a>
					</div>
					<div id="map">
						<img src="img/map.png" id="mapimg">
					</div>
					<b id="home_t">방으로</b> <b id="map_t">지도</b>
					<%
					} else {
					%>
					<div id="home"></div>
					<div id="map"></div>
					<b id="home_t"></b> <b id="map_t"></b>
					<%
					}
					%>
					<%
					if (Charac.story >= 5) {
					%>
					<div id="bag">
						<img src="img/bag.png" id="bagimg">
					</div>
					<b id="bag_t">가방</b>
					<%
					} else {
					%>
					<div id="bag"></div>
					<b id="bag_t"></b>
					<%
					}
					%>
				</div>
				<div id="show">
					<button onclick="showLog();">지난 기록 보기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button onclick="showStory();">지난 이야기 보기</button>
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