<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오피스하이 - 메인</title>
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="${resPath}/css/login.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<style type="text/css"></style>
</head>
<body>
	<main>
		<div class="content-box floating">
			<h2>테스트페이지 메인</h2>
			<p>${loginUser.userNo}</p>
			<p>${loginUser.admin}</p>
			<form action="${context}logout" method="post">
				<button type="submit">세션 제거 버튼</button>
			</form>
		</div>
	</main>
</body>
</html>