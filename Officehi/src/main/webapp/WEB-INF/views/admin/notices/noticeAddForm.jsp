<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
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
	<%@ include file="/WEB-INF/views/header/header.jsp"%>
	<main>
		<div class="main-container">
			<div class="aside-box">
				<ul class="aside floating">
					<li><span>사원 관리</span>
						<ul>
							<li><a href="${context}admin/employees"><span>사원 정보 관리</span></a></li>
						</ul></li>
					<li><span>전자 결재</span>
						<ul>
							<li><span>결재 문서 관리</span></li>
						</ul></li>
					<li><span>공지사항</span>
						<ul>
							<li><a href="${context}admin/notices"><span class="selected">공지사항 관리</span></a></li>
						</ul></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>공지사항 등록</h2>


					<form action="" method="post">
						<div class="mt-4 mb-4 row g-1 align-items-center">
							<div class="col-1">
								<label for="" class="form-label mb-0">제목</label>
							</div>
							<div class="col-11">
								<input type="text" class="form-control" id="noticeName" placeholder="제목을 입력해주세요">
							</div>
						</div>
						<div class="mb-4">
							<label for="noticeContent" class="form-label mb-2">내용</label>
							<textarea class="form-control form-control-lg" id="noticeContent" rows="3" style="height: 400px; resize: none;" placeholder="내용입력"></textarea>
						</div>

						<div class="noticeAdd">
							<button class="btn btn-dark btn-lg mt-3 me-3" id="arrival" onclick="location.href='${context}admin/notices'" type="button">등록 하기</button>
							<button class="btn btn-outline-dark btn-lg mt-3" id="leave" onclick="history.go(-1)" type="button">뒤로 가기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/footer/footer.jsp"%>
</body>
</html>