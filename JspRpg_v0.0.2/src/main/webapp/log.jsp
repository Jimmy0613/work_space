<%@page import="com.cre.w.rpg.game.Log"%>
<%@page import="com.cre.w.rpg.db.DataSelect"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지난 기록</title>
</head>
<body>
<%
Log l = new Log();
ArrayList<String> msgs = l.getLogAll();
for(String s: msgs){
	out.println(s);%><br><%
}
%>
</body>
</html>