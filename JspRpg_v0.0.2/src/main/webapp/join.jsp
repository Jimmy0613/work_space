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
<title>Insert title here</title>
<%
/* CSS/JS 파일 캐시 방지 */
String styleCss = application.getRealPath("/css/common.css");
File style = new File(styleCss);
Date lastModifiedStyle = new Date(style.lastModified());
SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmssSSS");

Member m = new Member();
%>
<link rel="stylesheet"
	href="css/common.css?ver=<%=fmt.format(lastModifiedStyle)%>">
<link rel="stylesheet"
	href="css/form.css?ver=<%=fmt.format(lastModifiedStyle)%>">
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
						<a href="index.jsp"><img src="img/home.png" id="icon"></a> <a
							href="login.jsp"><img src="img/login.png" id="icon"></a>
					</div>
					<div id="menu_t">
						<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;&nbsp;홈&nbsp;&nbsp;)&nbsp;&nbsp;&nbsp;&nbsp;(로그인)</b>
					</div>
				</div>
				<div id="c_mode">&nbsp;&nbsp;[ 현재 위치 ] 회원가입</div>
			</div>
			<div id="s_middle">
				<form action="proc/joinProc.jsp">
					<p id="form_i">
						<br>&nbsp;<b> 아이디*</b> &nbsp;&nbsp; <input name="id"
							placeholder=" 6~12자" maxlength="12" required> <br>&nbsp;
						<b>비밀번호* </b> <input name="pw1" type="password"
							placeholder=" 8~14자" maxlength="14" required> <br>&nbsp;
						<b> &nbsp; ㄴ확인* </b>&nbsp;<input name="pw2" type="password"
							placeholder=" 비밀번호 확인" maxlength="14" required> <br>
						&nbsp; <b> 닉네임* </b>&nbsp;&nbsp;&nbsp; <input type="text"
							name="m_name" placeholder=" 2~6자" maxlength="6" required>
						<br>&nbsp; <b> 이메일 </b>&nbsp; <input name="email1"> <b>@</b>
						<input name="email2">
						<button type="submit">가입하기</button>
					<b id="form_w">&nbsp;&nbsp;* 표시가 붙은 항목은 필수 입력 항목입니다.</b>
					</p>
				</form>
				<br>

			</div>
			<div id="s_banner_bot">
				&nbsp;
				<%=m.loginInfo()%></div>
		</div>

	</div>

</body>
</html>