<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>결재 문서 상세</title>
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
					<h2>결재 문서 상세</h2>
					<form id="approvalForm" action="${context}approvals/${approval.approvalNo}" method="post">
						<div class="row mb-3">
							<div class="col-2">
								<label class="form-label mt-2" for="category">서식</label>
							</div>
							<div class="col-3">
								<input type="text" class="form-control" id="category" name="category" value="${approval.category}" readonly>
							</div>
							<div class="col-2 mb-2">	
								<label class="form-label mt-2" for="checker">참조자</label>
							</div>
							<div class="col">
								<select	class="form-select" id="checker1" name="checker1">
									<option selected>${approval.checker1}</option>
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
								<input class="form-control" type="text" id="title" name="title" value="${approval.title}">
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-2">
								<label class="form-label mt-2" for="date">기안일</label>
							</div>
							<div class="col-3">
								<input class="form-control" type="text" name="date" value="${approval.date}" readonly>
							</div>
							<div class="col-2 mb-2">	
								<label class="form-label mt-2" for="checkDate">완료일</label>
							</div>
							<div class="col">
								<input class="form-control" type="date" id="checkDate" name="checkDate" value="${approval.checkDate}" readonly>
							</div>
						</div>
						<div class="row mb-3">
							<div class="">
								<label class="form-label" for="content">내용</label>
							</div>
							<div class="">
								<textarea class="form-control w-100" id="content" name="content" rows="13">${approval.content}</textarea>
							</div>
						</div>
						<div>
							<c:set var="status" value="${approval.status}" />
							<c:choose>
									<c:when test="${status == 1}"><c:set var="display" value=""/></c:when>
									<c:otherwise><c:set var="display" value="none"/></c:otherwise>
							</c:choose>
							<input class="btn btn-dark btn-small me-2" style="display: ${display};" type="submit" value="수정">
							<a class="btn btn-dark btn-small me-2" style="display: ${display};" onClick="javascript:updateStatus(${context}, ${approval.approvalNo}, 3)">승인</a>
							<a class="btn btn-dark btn-small me-2" style="display: ${display};" onClick="javascript:updateStatus(${context}, ${approval.approvalNo}, 2)">반려</a>
							<a class="btn btn-white btn-outline-dark btn-small" href="${context}approvals/">뒤로 가기</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<script src="${resPath}/js/approval-status.js" type="text/javascript"></script>
</body>
</html>