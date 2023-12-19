<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근무 시간 확인</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<style type="text/css">
.aside ul span {
	color: #222;
}

.aside ul span.selected {
	font-weight: 800;
	color: #345de3;
}
</style>
</head>
<body>
	<main>
		<div class="main-container">
			<div class="aside-box">
				<ul class="aside floating">
					<li><span>공지사항</span>
						<ul>
							<li><span>공지사항 조회</span></li>
						</ul></li>
					<li><span>전자 결재</span>
						<ul>
							<li><span>결재 현황 조회</span></li>
							<li><span>결재 문서 작성</span></li>
						</ul></li>
					<li><span>근태 관리</span>
						<ul>
							<li><a href="${context}works"><span>출퇴근 시간 기록</span></a></li>
							<li><a href="${context}works/list"><span class="selected">근무 시간 확인</span></a></li>
						</ul></li>
					<li><span>마이페이지</span></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>근무 시간 확인</h2>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">근무일</th>
								<th scope="col">사원명</th>
								<th scope="col">사번</th>
								<th scope="col">출근 시각</th>
								<th scope="col">퇴근 시각</th>
								<th scope="col">근무 시간</th>
							</tr>
						</thead>
						<tbody class="table-group-divider">
							<tr>
								<td>2023-12-18</td>
								<td>박재용</td>
								<td>12-012026</td>
								<td>09:25:30</td>
								<td>20:00:00</td>
								<td>8H</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>
</html>