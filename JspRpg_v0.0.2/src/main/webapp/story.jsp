<%@page import="com.cre.w.rpg.game.Charac"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cre.w.rpg.db.DataSelect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지난 이야기</title>
</head>
<body>
<%
DataSelect ds = new DataSelect();

ArrayList<Integer> st_num = new ArrayList<>();
ArrayList<String> st_title = new ArrayList<>();
ArrayList<String> st_desc = new ArrayList<>();
String where = "limit 0, " + Charac.story;
st_num = ds.dbExecuteQueryIntArr("st_num", "story", where);
st_title = ds.dbExecuteQueryStrArr("st_title", "story", where);
st_desc = ds.dbExecuteQueryStrArr("st_desc", "story", where);
if(st_num.size()!=0){
	for(int i = 0; i<st_num.size(); i++){
		String s = "<" + st_num.get(i) + "> " + st_title.get(i) + "(" + st_desc.get(i) + ")";
		out.println(s);%><br><%
	}
} else {
	out.println("아직 완료한 이야기가 없습니다.");
}

%>
</body>
</html>