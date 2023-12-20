<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 관리</title>
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

.table-group-divider tr td a {
	color: #222;
}

.pagination nav ul li a {
	color: #222;
}

.employeeIcons {
	
}

.modifyIcon:after {
	content: url("/officehi/resources/img/edit.svg");
	margin-left: 1em;
	vertical-align: top;
}

.retiredIcon:after {
	content: url("/officehi/resources/img/delete.svg");
	margin-left: 1em;
	vertical-align: top;
}

.retired {
	text-decoration: line-through;
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
					<h2 class="lgmg">사원 정보 관리</h2>
					<form action="${context}admin/employees/search" role="search" method="post">
						<div class="row g-2 align-items-center mb-3" id="employeesearch">
							<div class="col-3">
								<select class="form-select" name="searchType" aria-label="search">
									<option value="name">사원명</option>
									<option value="userNo">사번</option>
									<option value="deptName">부서명</option>
								</select>
							</div>
							<div class="col-5">
							<!-- 인풋이 여러개 있어야하나.. -->
								<input name="deptName" class="form-control col-auto" type="text" placeholder="검색 키워드를 입력하세요" aria-label="관리자 사원 검색">
							</div>
							<div class="col-auto">
								<button class="btn btn-dark" type="submit">검색</button>
							</div>
						</div>
					</form>

					<!-- 등록버튼 -->
					<div>
						<button class="btn btn-dark" type="button" onclick="location.href='${context}admin/employees/add'">신규 사원 등록</button>
					</div>

					<!-- 리스트 -->
					<table class="table mt-3">
						<thead>
							<tr>
								<th scope="col">사원명</th>
								<th scope="col">사번</th>
								<th scope="col">부서명</th>
								<th scope="col">직책</th>
								<th scope="col">입사일</th>
								<th scope="col">수정 / 퇴사</th>
							</tr>
						</thead>
						<tbody class="table-group-divider">
							<c:forEach var="employee" items="${employees}">
								<tr>
									<c:choose>
										<c:when test="${employee.fromDate eq '9999-01-01'}">
											<td><a href="${context}admin/employees/${employee.userNo}">${employee.name}</a></td>
										</c:when>
										<c:otherwise>
											<td><a href="${context}admin/employees/${employee.userNo}" class="retired">${employee.name}</a></td>
										</c:otherwise>
									</c:choose>
									<td><a href="${context}admin/employees/${employee.userNo}">${employee.userNo}</a></td>
									<td><a href="${context}admin/employees/${employee.userNo}">${employee.deptName}</a></td>
									<td><a href="${context}admin/employees/${employee.userNo}">${employee.position}</a></td>
									<td><a href="${context}admin/employees/${employee.userNo}">${employee.toDate}</a></td>
									<td>
										<!-- 삭제POST FORM --> <!-- <form id="retiredForm" action="${context}admin/employees/${employee.userNo}/retired" method="post"> -->
										<div class="employeeIcons">
											<a href="${context}admin/employees/${employee.userNo}"> <span class="modifyIcon"></span></a> <a href="${context}admin/employees/${employee.userNo}/retired"> <span class="retiredIcon"></span></a>
										</div> <!-- </form> -->
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- 페이지네이션 -->
					<div class="pagination d-flex justify-content-center mt-2">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/footer/footer.jsp"%>
</body>
</html>