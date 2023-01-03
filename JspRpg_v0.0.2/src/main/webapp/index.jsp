<%@page import="com.cre.w.rpg.db.Member"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_rpg_v0.0.1-홈</title>
<%
/* CSS/JS 파일 캐시 방지 */
String styleCss = application.getRealPath("/css/common.css");
File style= new File(styleCss);
Date lastModifiedStyle = new Date(style.lastModified());
SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmssSSS");

Member m = new Member();
Member.loginId = "";
Member.loginName = "";
Member.loginC1 = 0;
Member.loginC2 = 0;
%>
<link rel="stylesheet"
	href="css/common.css?ver=<%=fmt.format(lastModifiedStyle)%>">
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
						<a href="join.jsp"><img src="img/join.png" id="icon"></a> <a
							href="login.jsp"><img src="img/login.png" id="icon"></a>
					</div>
					<div id="menu_t">
						<b>&nbsp;&nbsp;&nbsp;(회원가입)&nbsp;&nbsp;&nbsp;&nbsp;(로그인)</b>
					</div>
				</div>
				<div id="c_mode">&nbsp;&nbsp;[ 현재 위치 ] 홈</div>
			</div>
			<div id="s_middle">
				<p>
					<b id="i">* 게임 방법 *</b> <br>
					<br>🐣 먼저 로그인해주세요. 가입하지 않으셨다면 가입부터 해주세요. <br>🐣 캐릭터를
					선택해주세요. 캐릭터가 없다면 만들어주세요. <br>🐣 캐릭터를 선택하면 게임이 시작됩니다. <br>🐣
					위쪽 화면을 봐주세요. 각 방향의 맵 정보가 있고, 이동을 클릭하면 해당 맵으로 이동합니다.
				</p>
			</div>
			<div id="s_banner_bot">
				&nbsp;
				<%=m.loginInfo()%>
			</div>
		</div>

	</div>

</body>
</html>