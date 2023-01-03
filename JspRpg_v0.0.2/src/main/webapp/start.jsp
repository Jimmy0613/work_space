<%@page import="com.cre.w.rpg.game.Log"%>
<%@page import="com.cre.w.rpg.game.Map"%>
<%@page import="com.cre.w.rpg.db.DataUpdate"%>
<%@page import="com.cre.w.rpg.db.DataSelect"%>
<%@page import="com.cre.w.rpg.game.Charac"%>
<%@page import="com.cre.w.rpg.db.Member"%>
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
	Member m = new Member();
	Charac c = new Charac();
	DataSelect ds = new DataSelect();
	DataUpdate du = new DataUpdate();
	Map map = new Map();
	Log l = new Log();
	
	map.loadMap();
	l.loadLog();
	Member.playerC = Integer.parseInt(request.getParameter("c_num"));
	c.loadCharacter();
	du.sendSystemMsg("[ " + Log.turnCount + " ] 환영합니다!");
	du.sendSystemMsg("💡 시스템 메시지는 캐릭터 변경, 로그아웃시 초기화됩니다.");
	response.sendRedirect("game.jsp?m_id=" + Charac.location + "&mode=normal");
	%>
</body>
</html>