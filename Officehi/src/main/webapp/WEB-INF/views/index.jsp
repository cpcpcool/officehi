<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="${resPath}/css/login.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<style type="text/css"></style>
</head>
<body>
	<main>
		<div class="content-box floating">
			<h1><img src="${resPath}/img/OfficeHi-logo.svg" alt="오피스하이 로고"></h1>
			<h2>로그인</h2>
			<form action="${context}login" method="post">
				<input type="text" id="userNo" name="userNo" placeholder="아이디를 입력해주세요">
				<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요">
				<button type="submit">로그인</button>
			</form>
		</div>
	</main>
</body>
</html>