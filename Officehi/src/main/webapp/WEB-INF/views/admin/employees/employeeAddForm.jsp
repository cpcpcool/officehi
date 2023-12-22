<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 등록</title>
<link rel="icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.ico'/>" />
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

.col-form-label {
	font-size: 0.85em;
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
							<li><a href="${context}admin/employees"><span class="selected">사원 정보 관리</span></a></li>
						</ul></li>
					<li><span>전자 결재</span>
						<ul>
							<li><span>결재 문서 관리</span></li>
						</ul></li>
					<li><span>공지사항</span>
						<ul>
							<li><a href="${context}admin/notices"><span>공지사항 관리</span></a></li>
						</ul></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>사원 정보 등록</h2>
					
					<!-- FORM -->
					<form:form action="${context}admin/employees/add" method="post">
						<div class="row mb-3">
							<label for="userNo" class="col-sm-2 col-form-label">사번</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="userNo" name="userNo" value="${lastUserNo}" readonly>
							</div>
							<label for="name" class="col-sm-2 col-form-label">이름</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="name" name="name" placeholder="이름">
							</div>
						</div>
						<div class="row mb-3">
							<label for="phone" class="col-sm-2 col-form-label">휴대폰 번호</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="phone" name="phone" placeholder="휴대폰 번호(-)" maxlength="13">
							</div>
							<label for="birthDate" class="col-sm-2 col-form-label">생년월일</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="birthDate" name="birthDate" placeholder="연도-월-일">
							</div>
						</div>
						<div class="row mb-3">
							<label for="toDate" class="col-sm-2 col-form-label">입사일</label>
							<div class="col-sm">
								<input type="date" class="form-control" id="toDate" name="toDate">
							</div>
							<label for="fromDate" class="col-sm-2 col-form-label">퇴사일</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="fromDate" name="fromDate" placeholder=" - " disabled>
							</div>
						</div>
						<div class="row mb-3">
							<label for="deptName" class="col-sm-2 col-form-label">부서명</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="deptName" name="deptName" placeholder="부서명">
							</div>
							<label for="position" class="col-sm-2 col-form-label">직급</label>
							<div class="col-sm">
								<select class="form-select" aria-label="position" name="position">
									<option selected>사원</option>
									<option>주임</option>
									<option>대리</option>
									<option>팀장</option>
									<option>대표</option>
								</select>
							</div>
						</div>
						<div class="row mb-3">
							<label for="profile" class="col-sm-2 col-form-label">프로필이미지 등록</label>
							<div class="col-sm">
								<input type="file" class="form-control" id="profile" name="profile">
							</div>
							<label for="stamp" class="col-sm-2 col-form-label">인감이미지 등록</label>
							<div class="col-sm">
								<input type="file" class="form-control" id="stamp" name="stamp">
							</div>
							</div>
							<!-- BUTTON -->
						<div class="employeesAdd">
							<button class="btn btn-dark btn-lg mt-3 me-3" id="add" type="submit">등록 하기</button>
							<button class="btn btn-outline-dark btn-lg mt-3" id="cancel" onclick="history.go(-1)" type="button">뒤로 가기</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/footer/footer.jsp"%>
</body>
</html>