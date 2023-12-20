<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>결재 문서 관리</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
</head>
<body>
	<main>
		<div class="main-container">
			<div class="aside-box">
				<ul class="aside floating">
					<li><span>사원 관리</span>
						<ul>
							<li><span>사원 정보 관리</span></li>
						</ul></li>
					<li><span>전자 결재</span>
						<ul>
							<li><span>결재 문서 관리</span></li>
						</ul></li>
					<li><span>공지사항</span>
						<ul>
							<li><span>공지사항 관리</span></li>
						</ul></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2 class="lgmg">결재 문서 관리</h2>
					<div>
						<form class="row" action="${context}admin/approvals" method="get">
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
								<input class="form-control" placeholder="검색 키워드를 입력하세요">
							</div>
							<div class="col-2">
								<button class="btn btn-dark" type="submit">검색</button>
							</div>
						</form>
					</div>
					<table>
						<thead>
							<tr>
								<th>문서번호</th>
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
									<td>${approval.approvalNo}</td>
									<td>${approval.userName}</td>
									<td><a href="${context}approvals/${approval.approvalNo}">${approval.title}</a></td>
									<td>${approval.deptName}</td>
									<td>${approval.date}</td>
									<td>
										<c:if test="${\"${approvals.checkDate}\" eq '9999-01-01'}">
											<c:out value="${approvals.checkDate}" />
										</c:if>
									</td>
									<td>
										<a href="${context}approvals/${approval.approvalNo}" class="px-2"><img src="${resPath}/img/edit.svg" alt="수정"></a>
										<a href="javascript:void(0)" onClick="javascript:delApprovl(${context}, ${approval.approvalNo})"><img src="${resPath}/img/delete.svg" alt="삭제"></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<script src="${resPath}/js/approval-delete.js" type="text/javascript"></script>
</body>
</html>