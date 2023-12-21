<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>결재 현황 조회</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
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
					<h2>결재 현황 조회</h2>
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
											<a href="javascript:void(0)" onClick="javascript:delApprovl(${context}, ${approval.approvalNo})"><img src="${resPath}/img/delete.svg" alt="삭제"></a>
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
	<script src="${resPath}/js/approval-delete.js" type="text/javascript" ></script>
</body>
</html>