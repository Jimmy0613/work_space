<%@page import="com.cre.w.rpg.game.Map"%>
<%@page import="com.cre.w.rpg.game.Charac"%>
<%@page import="com.cre.w.rpg.db.Member"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@page import="com.cre.w.rpg.db.DataSelect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_rpg_v0.0.1-캐릭터선택</title>
<%
	/* CSS/JS 파일 캐시 방지 */
	String styleCss = application.getRealPath("/css/common.css");
	File style = new File(styleCss);
	Date lastModifiedStyle = new Date(style.lastModified()); 
	SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmssSSS");
	
	Member m = new Member();
	DataSelect ds = new DataSelect();
%>
<link rel="stylesheet" href="css/common.css?ver=<%=fmt.format(lastModifiedStyle)%>">
<link rel="stylesheet" href="css/form.css?ver=<%=fmt.format(lastModifiedStyle)%>">
</head>
<body>
	<div id="gamebox">
		<div id="screen">
			<div id="t">
				<b id="title">&nbsp; jsp_rpg_v0.0.1</b>
				<hr>
			</div>
				<div id="n">
			<button>이동</button>
				&nbsp;북쪽 맵 이름 
				
			</div>
			<div id="w">
				서쪽 맵 이름<br>
				<button>이동</button>
			</div>
			<div id="c">
				<b>현재 맵</b>
			</div>
			<div id="e">
			<button>이동</button>
				동쪽 맵 이름
				
			</div>
			<div id="s">
			<button>이동</button>
				&nbsp;남쪽 맵 이름 
			</div>
		</div>
		<div id="system">
			<div id="s_banner_top">
				<div id="menu">
					<div id="menu_i">
					<a href="proc/logoutProc.jsp"><img src="img/logout.png" id="icon"></a>
					</div>
					<div id="menu_t">
					<b>&nbsp;&nbsp;(로그아웃)</b>
					</div>
				</div>
				<div id="c_mode">&nbsp;&nbsp;[ 현재 위치 ] 캐릭터 선택</div>
			</div>
			<div id="s_middle">
			<div id="character">
			<div id="c_info">
			<%
			if(m.isChar("m_char1")){
			%>
			<p id="form_w">&nbsp;[ 캐릭터 1 ] <br><br><%=m.charProfile("m_char1") %></p>
			&nbsp;&nbsp;<button onclick="location.href='start.jsp?c_num=<%=Member.loginC1%>'">선택하기</button>
			<%
			} else {
			%>
			<p id="form_w">&nbsp;[ 캐릭터 1 ]<br> <br>아직 캐릭터가 없습니다.</p>
			&nbsp;&nbsp;<button onclick="location.href='newChar.jsp?num=1'">만들기</button>
			<%
			}
			%>
			</div>
			<div id="c_info">
			<%
			if(m.isChar("m_char2")){
			%>
			<p id="form_w">&nbsp;[ 캐릭터 2 ] <br><br><%=m.charProfile("m_char2") %></p>
			&nbsp;&nbsp;<button onclick="location.href='start.jsp?c_num=<%=Member.loginC2%>'">선택하기</button>
			<%
			} else {
			%>
			<p id="form_w">&nbsp;[ 캐릭터 2 ] <br><br>아직 캐릭터가 없습니다.</p>
			&nbsp;&nbsp;<button onclick="location.href='newChar.jsp?num=2'">만들기</button>
			<%
			}
			%>
			</div>
			</div>
			</div>
			<div id="s_banner_bot">
				&nbsp; <%=m.loginInfo() %>
			</div>
		</div>

	</div>

</body>
</html>