<%@page import="java.util.ArrayList"%>
<%@page import="com.cre.w.rpg.game.System"%>
<%@page import="com.cre.w.rpg.db.Member"%>
<%@page import="com.cre.w.rpg.game.Map"%>
<%@page import="com.cre.w.rpg.game.Character"%>
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
	href="../css/common.css?ver=<%=fmt.format(lastModifiedStyle)%>">
<link rel="stylesheet"
	href="../css/map.css?ver=<%=fmt.format(lastModifiedStyle)%>">
</head>
<body>

	<%
	Member m = new Member();
	Character c = new Character();
	DataSelect ds = new DataSelect();
	Map map = new Map();
	Map.m_id = Integer.parseInt(request.getParameter("m_id"));
	Member.playerC = Integer.parseInt(request.getParameter("c_num"));
	map.loadMap();
	c.loadCharacter();
	String mode = request.getParameter("mode");
	System.turnCount++;
	switch (mode) {
	case "start":
		System.message = new ArrayList<>();
		System.turnCount = 0;
		System.message.add("[ " + System.turnCount + " ] 환영합니다!");
		break;
	case "move":
		System.message.add("[ " + System.turnCount + " ] 이동했습니다.");
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
					onclick="location.href='m_<%=Map.north_map %>.jsp?m_id=<%=Map.north_map%>&c_num=<%=Member.playerC%>&mode=move'">이동</button>
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
					onclick="location.href='m_<%=Map.west_map %>.jsp?m_id=<%=Map.west_map%>&c_num=<%=Member.playerC%>&mode=move'">이동</button>
				<%
				} else {
				%>
				이곳은<br> 막혀있다.
				<%
				}
				%>
			</div>
			<div id="c"></div>
			<div id="e">

				<%
				if (Map.east_map != 0) {
				%>
				<button
					onclick="location.href='m_<%=Map.east_map %>.jsp?m_id=<%=Map.east_map%>&c_num=<%=Member.playerC%>&mode=move'">이동</button>
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
					onclick="location.href='m_<%=Map.south_map %>.jsp?m_id=<%=Map.south_map%>&c_num=<%=Member.playerC%>&mode=move'">이동</button>
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
						<a href="../proc/logoutProc.jsp"><img src="../img/logout.png"
							id="icon"></a>
					</div>
					<div id="menu_t">
						<b>&nbsp;&nbsp;(로그아웃)</b>
					</div>
				</div>
				<div id="c_mode">
					&nbsp;&nbsp;
					<%=Character.info%></div>
			</div>
			<div id="s_middle">
				<b><%=map.getInfo(Map.m_id)%></b>
				<textarea readonly id="msgbox">
					<%
					for (String s : System.message) {
						out.println(s);
					}
					%>
				</textarea>
			</div>
			<div id="s_banner_bot">
				&nbsp;
				<%=m.loginInfo()%>
			</div>
		</div>

	</div>
</body>
</html>