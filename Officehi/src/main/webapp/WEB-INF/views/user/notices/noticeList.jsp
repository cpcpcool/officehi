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
<style>
thead {
	text-align: left
}

.aside ul span.selected {
	font-weight: 800;
	color: #345de3;
}
</style>
</head>
<body>
	<%@ include file="../../header/header.jsp"%>
	<main>
		<div class="main-container">
			<div class="aside-box">
				<ul class="aside floating">
					<li><span>공지사항</span>
						<ul>
							<li><a href="${context}notices"><span class="selected">공지사항 조회</span></a></li>
						</ul></li>
					<li><span>전자 결재</span>
						<ul>
							<li><a href="${context}approvals"><span>결재 현황 조회</span></a></li>
							<li><a href="${context}approvals/add"><span>결재 문서 작성</span></a></li>
						</ul></li>
					<li><span>근태 관리</span>
						<ul>
							<li><a href="${context}works"><span>출퇴근 시간 기록</span></a></li>
							<li><a href="${context}works/list"><span>근무 시간 확인</span></a></li>
						</ul></li>
					<li><a href="${context}mypage"><span>마이페이지</span></a></li>
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
									<td><a href="${context}notices/${notice.noticeNo}">${notice.title}</a></td>
									<td><a href="${context}notices/${notice.noticeNo}">${notice.date}</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

	<%@ include file="../../footer/footer.jsp"%>
</body>
</html>