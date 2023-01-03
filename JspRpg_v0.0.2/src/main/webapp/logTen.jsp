<%@page import="com.cre.w.rpg.game.Log"%>
<%@page import="java.util.ArrayList"%>
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
Log l = new Log();
ArrayList<String> msgs = l.getLogTen();
for(int i = msgs.size()-1; i>=0; i--){
	out.println(msgs.get(i));%><br><%
}
%>
</body>
</html>