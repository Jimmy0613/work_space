<%@page import="com.cre.w.rpg.db.DataUpdate"%>
<%@page import="com.cre.w.rpg.db.DataSelect"%>
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
	String id = "";
	String pw = "";
	String m_name = "";
	String email = "";
	boolean idCheck = false;
	boolean pwCheck = false;
	boolean nameCheck = false;
	boolean emailCheck = false;
	String alert = "";
	
	//id 체크(6~12자)
	id = request.getParameter("id");
	if (id != null) {
		if (id.length() >= 6) {
			DataSelect ds = new DataSelect();
			int cnt = -1;
			String where = "where id = '" + id + "'";
			cnt = ds.dbExecuteQueryInt("count(*)", "members", where);
			if (cnt < 1) {
				idCheck = true;
			} else {
				alert = alert + "(중복된 아이디) ";
			}
			
		} else {
			alert = alert + "(아이디 글자 수 확인) ";
		}
	}

	//비번 체크
	String pw1 = request.getParameter("pw1");
	String pw2 = request.getParameter("pw2");
	if (pw1 != null) {
		if (pw1.length() >= 8) {
			if (pw2 != null) {
				if (pw2.equals(pw1)){
					pw = pw2;
					pwCheck = true;
				} else {
					alert = alert + "(비밀번호 일치하지 않음) ";
				}
			}
		} else {
			alert = alert + "(비밀번호 글자 수 확인) ";
		}
	}

	//이름 체크
	m_name = request.getParameter("m_name");
	if (m_name != null) {
		if (m_name.length() >= 2) {
			nameCheck = true;	
		} else {
			alert = alert + "(이름 글자 수 확인) ";
		}
	}
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	if (email1 == null || email2 == null){
		email = "미등록";
		emailCheck = true;
	} else{
		email = email1 + "@" + email2;
		emailCheck = true;
	}
	if(idCheck && pwCheck && nameCheck && emailCheck){
		DataUpdate du = new DataUpdate();
		String query = "insert into members(id,pw,m_name,e_mail) values('"+id+"', '"+pw+"', '"+m_name+"', '"+email+"')";
		du.dbExecuteUpdate(query);
		out.println("<script>alert('가입이 완료되었습니다. 홈으로 이동합니다.');</script>");
		out.println("<script>location.href='../index.jsp'</script>");		
	} else {
		out.println("<script>alert('가입에 실패하였습니다. " + alert + "');</script>");
		out.println("<script>location.href='../join.jsp'</script>");
	}

	%>

</body>
</html>