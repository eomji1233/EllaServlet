<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MemberWeb Home</title>
	</head>
	<body>
		<h1>환영합니다 MemberWeb Home입니다~</h1>
		<c:if test="${sessionScope.memberId != null }">
			${sessionScope.memberName }님 환영합니다~! <br>
			<a href="#">마이페이지</a>
			<a href="#">회원탈퇴</a>
			<a href="/member/logout.do">로그아웃</a>
<%-- 		<% if(sessionScope.memberId != null) { %> --%>
		
<%-- 		<% } else { %> --%>
		</c:if>
		<c:if test="${sessionScope.memberId == null }">
<!-- 		requestScope랑 같은 값이 있을수도 있으니까 명시, 생략가능 -->
			<form action="/member/login.do" method="post">
			<fieldset>
				<legend>로그인</legend>
				ID : <input type="text" name="memberId"> <br>
				PW : <input type="password" name="memberPw"> <br>
				<input type="submit" value="로그인">
			</fieldset>		
			</form>
		</c:if>
<%-- 		<% } %> --%>
	</body>
</html>