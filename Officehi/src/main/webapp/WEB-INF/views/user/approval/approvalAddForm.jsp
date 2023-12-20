<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>결재 문서 작성</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<style type="text/css">
	form {
		font-size: 16px;
		font-weight: bold;
		line-height: 16px;
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
							<li><span>공지사항 조회</span></li>
						</ul></li>
					<li><span>전자 결재</span>
						<ul>
							<li><span>결재 현황 조회</span></li>
							<li><span>결재 문서 작성</span></li>
						</ul></li>
					<li><span>근태 관리</span>
						<ul>
							<li><span>출퇴근 시간 기록</span></li>
							<li><span>근무 시간 확인</span></li>
						</ul></li>
					<li><span>마이페이지</span></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>결재 문서 작성</h2>
					<form action="${context}approvals/add" method="post">
						<div class="row mb-3">
							<div class="col-2">
								<label class="form-label mt-2" for="category">서식</label>
							</div>
							<div class="col-3">
								<select class="form-select" id="category" name="category" required>
									<option>휴가신청서</option>
									<option>대금결재</option>
									<option>결재2</option>
									<option>결재결재</option>
								</select>
							</div>
							<div class="col-2 mb-2">	
								<label class="form-label mt-2" for="checker">참조자</label>
							</div>
							<div class="col">
								<select	class="form-select" id="checker1" name="checker1">
									<c:forEach var="userList" items="${userList}">
										<option>${userList.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-2 mt-2">
								<label class="form-label" for="title">문서 제목</label>
							</div>
							<div class="col">
								<input class="form-control" type="text" id="title" name="title" placeholder="년-월-일 서식명 사원명" required>
							</div>
						</div>
						<div class="row mb-3">
							<div class="">
								<label class="form-label" for="content">내용</label>
							</div>
							<div class="">
								<textarea class="form-control w-100" id="content" name="content" rows="13" required></textarea>
							</div>
						</div>
						<div>
							<button class="btn btn-dark btn-small me-2" type="submit">결재요청</button>
							<button class="btn btn-white btn-outline-dark btn-small" onClick="history.back()">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="../../footer/footer.jsp"%>
</body>
</html>