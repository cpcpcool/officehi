<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!-- 
 * @author 엄다빈
 * @editDate 23.12.19 ~23.12.19
 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>결재 문서 관리</title>
<link rel="icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.ico'/>" />
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
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
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header/adminHeader.jsp"%>
	<main>
		<div class="main-container">
			<%@ include file="/WEB-INF/views/aside/adminAside.jsp" %>
			<div class="main-box">
				<div class="content-box floating">
					<h2 class="lgmg">결재 문서 관리</h2>
					<div>
						<form class="row" action="${context}admin/approvals/search" method="get">
							<div class="col-2">
								<select class="form-select" name="search">
										<option value="approvalNo">문서번호</option>
										<option value="userNo">기안자</option>
										<option value="title">문서 제목</option>
										<option value="deptName">부서</option>
										<option value="date">기안일</option>
										<option value="checkDate">완료일</option>
								</select>
							</div>
							<div class="col-4">
								<input name="searchValue" class="form-control" placeholder="검색 키워드를 입력하세요">
							</div>
							<div class="col-2">
								<button class="btn btn-dark" type="submit">검색</button>
							</div>
						</form>
					</div>
					<table>
						<thead>
							<tr>
							<th>결재상태</th>
								<th>문서번호</th>
								<th>기안자</th>
								<th>문서 제목</th>
								<th>부서</th>
								<th>기안일</th>
								<th>완료일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="approval" items="${approvals}">
								<tr>
									<td>
										<c:set var="status" value="${approval.status}" />
										<c:choose>
											<c:when test="${status == 1}">신청</c:when>
											<c:when test="${status == 2}">반려</c:when>
											<c:when test="${status == 3}">완료</c:when>
										</c:choose>
									</td>
									<td>${approval.approvalNo}</td>
									<td>${approval.name}</td>
									<td><a href="${context}admin/approvals/${approval.approvalNo}">${approval.title}</a></td>
									<td>${approval.deptName}</td>
									<td>${approval.date}</td>
									<td>
										<c:if test="${approval.checkDate != '9999-01-01'}">
											${approval.checkDate}
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/footer/adminFooter.jsp"%>
</body>
</html>