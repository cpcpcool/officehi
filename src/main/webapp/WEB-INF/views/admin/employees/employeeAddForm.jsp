<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!--
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22
 * 파일 업로드기능 추가 23.12.26 ~ 23.12.27
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 등록</title>
<link rel="icon" type="image/x-icon"
	href="<c:url value='/resources/img/favicon.ico'/>" />
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css"
	rel="stylesheet">
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

.error {
	color: #f00;
	font-size: 0.8em;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header/adminHeader.jsp"%>
	<main>
		<div class="main-container">
			<%@ include file="/WEB-INF/views/aside/adminAside.jsp"%>
			<div class="main-box">
				<div class="content-box floating">
					<h2>사원 정보 등록</h2>

					<!-- FORM -->
					<form:form action="${context}admin/employees/add" method="post"
						modelAttribute="employeeDTO" enctype="multipart/form-data">
						<div class="row mb-3">
							<label for="userNo" class="col-sm-2 col-form-label">사번</label>
							<div class="col-sm">
								<form:input path="userNo" cssClass="form-control" id="userNo"
									value="${lastUserNo}" readonly="true" />
							</div>
							<label for="name" class="col-sm-2 col-form-label">이름</label>
							<div class="col-sm">
								<form:input path="name" cssClass="form-control" id="name"
									placeholder="이름" />
								<form:errors path="name" cssClass="error" />
							</div>
						</div>
						<div class="row mb-3">
							<label for="phone" class="col-sm-2 col-form-label">휴대폰 번호</label>
							<div class="col-sm">
								<form:input path="phone" cssClass="form-control" id="phone"
									placeholder="휴대폰 번호(-)" maxlength="13" />
								<form:errors path="phone" cssClass="error" />
							</div>
							<label for="birthDate" class="col-sm-2 col-form-label">생년월일</label>
							<div class="col-sm">
								<form:input path="birthDate" cssClass="form-control"
									id="birthDate" placeholder="연도-월-일" />
								<form:errors path="birthDate" cssClass="error" />
							</div>
						</div>
						<div class="row mb-3">
							<label for="toDate" class="col-sm-2 col-form-label">입사일</label>
							<div class="col-sm">
								<form:input path="toDate" cssClass="form-control" id="toDate"
									type="date" />
								<form:errors path="toDate" cssClass="error" />
							</div>
							<label for="fromDate" class="col-sm-2 col-form-label">퇴사일</label>
							<div class="col-sm">
								<form:input path="fromDate" cssClass="form-control"
									id="fromDate" disabled="true" placeholder="-" />
								<form:errors path="fromDate" cssClass="error" />
							</div>
						</div>
						<div class="row mb-3">
							<label for="deptName" class="col-sm-2 col-form-label">부서명</label>
							<div class="col-sm">
								<select class="form-select" aria-label="deptName"
									name="deptName">
									<option selected>인사</option>
									<option>회계</option>
									<option>마케팅</option>
									<option>CS</option>
									<option>개발</option>
								</select>
							</div>
							<label for="position" class="col-sm-2 col-form-label">직급</label>
							<div class="col-sm">
								<select class="form-select" aria-label="position"
									name="position">
									<option selected>사원</option>
									<option>주임</option>
									<option>대리</option>
									<option>팀장</option>
									<option>대표</option>
								</select>
							</div>
						</div>
						<div class="row mb-3">
							<label for="profile" class="col-sm-2 col-form-label">프로필이미지</label>
							<div class="col-sm">
								<div class="input-group flex-wrap">
									<input type="text" class="form-control" id="profileFileName"
										name="profileFileName" >
									<input type="file" id="profile" name="profile" style="display: none;"
										onchange="updateFileName('profile', 'profileFileName')">
									<button type="button" class="btn btn-outline-secondary"
										onclick="document.getElementById('profile').click()">파일추가</button>
								</div>
							</div>
							<label for="stamp" class="col-sm-2 col-form-label">인감이미지</label>
							<div class="col-sm">
								<div class="input-group flex-wrap">
									<input type="text" class="form-control" id="stampFileName"
										name="stampFileName">
									<input type="file" id="stamp" name="stamp" style="display: none;"
										onchange="updateFileName('stamp', 'stampFileName')">
									<button type="button" class="btn btn-outline-secondary"
										onclick="document.getElementById('stamp').click()">파일추가</button>
								</div>
							</div>
						</div>
						<!-- BUTTON -->
						<div class="employeesAdd">
							<button class="btn btn-dark btn-lg mt-3 me-3" id="add"
								type="submit">등록 하기</button>
							<button class="btn btn-outline-dark btn-lg mt-3" id="cancel"
								onclick="history.go(-1)" type="button">뒤로 가기</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/footer/adminFooter.jsp"%>
	<script type="text/javascript" src="${resPath}/js/fileUpload.js"></script>
</body>
</html>