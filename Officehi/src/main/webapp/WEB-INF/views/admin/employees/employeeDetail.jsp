<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!--
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 상세</title>
<script type="text/javascript" src="${resPath}/js/employeeEdit.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
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
			<%@ include file="../../aside/adminAside.jsp" %>
			<div class="main-box">
				<div class="content-box floating">
					<h2>사원 정보 상세</h2>

					<!-- FORM -->

					<form:form action="${context}admin/employees/${employee.userNo}" id="employeeInfo" method="post">
						<div class="row mb-3">
							<label for="userNo" class="col-sm-2 col-form-label">사번</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="userNo" name="userNo" value="${employee.userNo}" readonly>
							</div>
							<label for="name" class="col-sm-2 col-form-label">이름</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="name" name="name" value="${employee.name}">
								<div class="valid-feedback">Valid.</div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
						</div>
						<div class="row mb-3">
							<label for="phone" class="col-sm-2 col-form-label">휴대폰 번호</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="phone" name="phone" value="${employee.phone}" maxlength="13">
							</div>
							<label for="birthDate" class="col-sm-2 col-form-label">생년월일</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="birthDate" name="birthDate" value="${employee.birthDate}">
							</div>
						</div>
						<div class="row mb-3">
							<label for="toDate" class="col-sm-2 col-form-label">입사일</label>
							<div class="col-sm">
								<input type="date" class="form-control" id="toDate" name="toDate" value="${employee.toDate}">
							</div>
							<label for="fromDate" class="col-sm-2 col-form-label">퇴사일</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="fromDate" name="fromDate" value="${employee.fromDate}" disabled>
							</div>
						</div>
						<div class="row mb-3">
							<label for="deptName" class="col-sm-2 col-form-label">부서명</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="deptName" name="deptName" value="${employee.deptName}">
							</div>
							<label for="position" class="col-sm-2 col-form-label">직급</label>
							<div class="col-sm">
								<select class="form-select" aria-label="position" name="position">
									<option selected>${employee.position}</option>
									<option>사원</option>
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
								<input type="text" class="form-control" value="${employee.profile}" disabled>
							</div>
							<label for="stamp" class="col-sm-2 col-form-label">인감이미지 등록</label>
							<div class="col-sm">
								<input type="text" class="form-control" id="stamp" name="stamp" value="${employee.stamp}" disabled>
							</div>
						</div>
						<!-- BUTTON -->
						<div class="employeeEdit">
							<button class="btn btn-dark btn-lg mt-3 me-3 .editButton" id="${employee.userNo}" type="submit">수정 하기</button>
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