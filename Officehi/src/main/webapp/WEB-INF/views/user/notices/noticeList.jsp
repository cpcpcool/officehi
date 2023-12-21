<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.ico'/>" />
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="${resPath}/css/header.css" rel="stylesheet">
<link href="${resPath}/css/footer.css" rel="stylesheet">
<style>
thead {
	text-align: left
}
a {
	color: #222;
}
</style>
</head>
<body>
	<header>
		<div class="header-container">
			<div class="header-left">
				<div class="logo-box">
					<a href="#"> <img src="${resPath}/img/OfficeHi-logo.svg" alt="오피스하이 로고">
					</a>
				</div>
				<ul class="header-menu">
					<li><a href="${context}notices" class="reset">공지사항</a></li>
					<li><a href="${context}approvals">전자 결재</a></li>
					<li><a href="${context}works">근태 관리</a></li>
					<li><a href="${context}mypage">마이페이지</a></li>
				</ul>
			</div>
			<div class="header-right">
				<a href="#"><span>로그아웃</span></a>
			</div>
		</div>
	</header>

	<main>
		<div class="main-container">
			<div class="aside-box">
				<ul class="aside floating">
					<li><span>공지사항</span>
						<ul>
							<li><span><a href="${context}notices">공지사항 조회</a></span></li>
						</ul></li>
					<li><span>전자 결재</span>
						<ul>
						<li><span><a href="${context}approvals">결재 현황 조회</a></span></li>
							<li><span><a href="${context}approvals/add">결재 문서 작성</a></span></li>
						</ul></li>
					<li><span>근태 관리</span>
						<ul>
							<li><span><a href="${context}works">출퇴근 시간 기록</a></span></li>
							<li><span><a href="${context}works/list">근무 시간 확인</a></span></li>
						</ul></li>
					<li><span><a href="${context}mypage">마이페이지</a></span></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>공지사항 조회</h2>
					<table>
						<thead>
							<tr>
								<th>제목</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="notice" items="${notices}">
								<tr>
									<td><a href="${context}notices/${notice.notice_no}">${notice.title}</a></td>
									<td><a href="${context}notices/${notice.notice_no}">${notice.date}</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

	<footer>
		<div class="footer-top">
			<div class="footer-container">
				<ul class="footer-menu">
					<li><a href="${context}notices">공지사항</a></li>
					<li><a href="${context}approvals">전자 결재</a></li>
					<li><a href="${context}works">근태 관리</a></li>
					<li><a href="${context}mypage">마이페이지</a></li>
				</ul>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="footer-container">
				<div>
					<img src="${resPath}/img/OfficeHi-logo.svg" alt="오피스하이 로고">
				</div>
				<p>Copyright &copy; OfficeHi, All right reserved</p>
			</div>
		</div>
	</footer>
</body>
</html>