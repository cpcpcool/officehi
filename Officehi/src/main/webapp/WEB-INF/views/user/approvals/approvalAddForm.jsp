<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
					<li>
					<span>공지사항</span>
						<ul>
							<li><a href="#"><span>공지사항 조회</span></a></li>
						</ul>
					</li>
					<li><span>전자 결재</span>
						<ul>
							<li><a href="${context}approvals"><span>결재 현황 조회</span></a></li>
							<li><a href="${context}approvals/add"><span>결재 문서 작성</span></a></li>
						</ul></li>
					<li><span>근태 관리</span>
						<ul>
							<li><a href="#"><span>출퇴근 시간 기록</span></a></li>
							<li><a href="#"><span>근무 시간 확인</span></a></li>
						</ul></li>
					<li><a href="#"><span>마이페이지</span></a></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>결재 문서 작성</h2>
					<form:form modelAttribute="approval" action="${context}approvals/add" method="post">
						<div class="row mb-3">
							<div class="col-2">
								<label class="form-label mt-2" for="category">서식</label>
							</div>
							<div class="col-3">
								<form:select path="category" class="form-select" required="true">
									<option>휴가신청서</option>
									<option>대금결재</option>
									<option>결재2</option>
									<option>결재결재</option>
								</form:select>
							</div>
							<div class="col-2 mb-2">	
								<label class="form-label mt-2" for="checker">참조자</label>
							</div>
							<div class="col">
								<form:select path="checker1" class="form-select" id="checker1" name="checker1">
									<form:options items="${userList}" itemValue="name" itemLabel="name" />
								</form:select>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-2 mt-2">
								<label class="form-label" for="title">문서 제목</label>
							</div>
							<div class="col">
								<form:input path="title" cssClass="form-control" placeholder="년-월-일 서식명 사원명" required="true" />
							</div>
						</div>
						<div class="row mb-3">
							<div class="">
								<label class="form-label" for="content">내용</label>
							</div>
							<div class="">
								<form:textarea path="content" class="form-control w-100" style="height: 400px; resize: none;" required="true" />
							</div>
						</div>
						<div>
							<form:button class="btn btn-dark btn-small me-2" type="submit">결재요청</form:button>
							<form:button class="btn btn-white btn-outline-dark btn-small" onClick="history.back()">취소</form:button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="../../footer/footer.jsp"%>
</body>
</html>