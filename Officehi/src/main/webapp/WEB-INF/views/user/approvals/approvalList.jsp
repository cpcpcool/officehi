<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!-- 
 * @author 엄다빈
 * @editDate 23.12.15 ~23.12.18
 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>결재 현황 조회</title>
<link rel="icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.ico'/>" />
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
	<%@ include file="../../header/header.jsp"%>
	<main>
		<div class="main-container">
			<%@ include file="../../aside/userAside.jsp" %>
			<div class="main-box">
				<div class="content-box floating">
					<h2>결재 현황 조회</h2>
					<div>
						<a href="${context}approvals" class="btn btn-dark btn-small me-2">전체 보기</a>
						<a href="${context}approvals/search?search=my" class="btn btn-dark btn-small me-2">내 작성글 보기</a>
						<a href="${context}approvals/search?search=other" class="btn btn-dark btn-small me-2">내 요청글 보기</a>
					</div>
					<table>
						<thead>
							<tr>
								<th>결재상태</th>
								<th>기안자</th>
								<th>문서 제목</th>
								<th>부서</th>
								<th>기안일</th>
								<th>완료일</th>
								<th>수정/삭제</th>
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
									<td>${approval.name}</td>
									<td><a href="${context}approvals/${approval.approvalNo}">${approval.title}</a></td>
									<td>${approval.deptName}</td>
									<td>${approval.date}</td>
									<td>
										<c:if test="${approval.checkDate != '9999-01-01'}">
											${approval.checkDate}
										</c:if>
									</td>
									<c:if test="${approval.status == 1 && loginUser.userNo == approval.userNo}">
										<td>
											<a href="${context}approvals/${approval.approvalNo}" class="px-3"><img src="${resPath}/img/edit.svg" alt="수정"></a>
											<a href="javascript:void(0)" onClick="javascript:deleteApproval(${context}, ${approval.approvalNo})"><img src="${resPath}/img/delete.svg" alt="삭제"></a>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="../../footer/footer.jsp"%>
	<script src="${resPath}/js/approval.js" type="text/javascript" ></script>
</body>
</html>