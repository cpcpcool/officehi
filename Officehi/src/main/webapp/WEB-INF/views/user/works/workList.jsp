<%@page import="java.time.LocalTime"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@ page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근무 시간 확인</title>
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
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header/header.jsp"%>
	<main>
		<div class="main-container">
			<%@ include file="../../aside/userAside.jsp" %>
			<div class="main-box">
				<div class="content-box floating">
					<h2>근무 시간 확인</h2>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">근무일</th>
								<th scope="col">사원명</th>
								<th scope="col">사번</th>
								<th scope="col">출근 시각</th>
								<th scope="col">퇴근 시각</th>
								<th scope="col">근무 시간</th>
							</tr>
						</thead>
						<tbody class="table-group-divider">
							<c:forEach var="work" items="${works}">
								<tr>
									<td>${work.date}</td>
									<td>${work.name}</td>
									<td>${work.userNo}</td>
									<td>${work.arrivalTime}</td>
									<td>${work.leaveTime}</td>
									<td>${work.getWorkTimeHour()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/footer/footer.jsp"%>
</body>
</html>