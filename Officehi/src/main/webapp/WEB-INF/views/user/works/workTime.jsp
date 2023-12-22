<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출퇴근 시간 기록</title>
<script type="text/javascript" src="${resPath}/js/time.js"></script>
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

#date {
	margin-top: 10px;
	font-size: 1.2em;
}

#currentTime {
	margin-top: 30px;
	font-weight: 900;
	font-size: 3em;
}
#arrival {
	text-align: center;
	background-color: #345de3;
}

#arrival:hover {
	background-color: #345dff;
}
/* #arrival:active {
	font-size: .95em;
}
#leave{
}
#leave:active {
	font-size: .95em;
} */
</style>

</head>
<body onload="getTime()">
	<%@ include file="/WEB-INF/views/header/header.jsp"%>
	<main>
		<div class="main-container">
			<%@ include file="../../aside/userAside.jsp" %>
			<div class="main-box">
				<div class="content-box floating">
					<h2>출퇴근 시간 기록</h2>
					<%
					LocalDate now = LocalDate.now();
					int year = now.getYear();
					int monthValue = now.getMonthValue();
					int dayOfMonth = now.getDayOfMonth();
					int dayOfWeekValue = now.getDayOfWeek().getValue();
					%>

					<%!String koDayofWeek = "";%>
					<%
					switch (dayOfWeekValue) {
						case 1 :
							koDayofWeek = "월";
							break;
						case 2 :
							koDayofWeek = "화";
							break;
						case 3 :
							koDayofWeek = "수";
							break;
						case 4 :
							koDayofWeek = "목";
							break;
						case 5 :
							koDayofWeek = "금";
							break;
						case 6 :
							koDayofWeek = "토";
							break;
						case 7 :
							koDayofWeek = "일";
							break;
					}
					%>
					<p id="date"><%=year%>.
						<%=monthValue%>.
						<%=dayOfMonth%>
						<%=koDayofWeek%></p>
					<p id="currentTime"></p>
					<div class="d-flex">
						<form class="arrival" action="${context}works/arrival" method="post">
							<input type="hidden" name="userNo" value="${loginUser}" />
							<button class="btn btn-primary btn-lg mt-4 me-3" type="submit">출근 하기</button>
						</form>
						<form class="leave" action="${context}works/leave" method="post">
							<input type="hidden" name="userNo" value="${loginUser}" />
							<button class="btn btn-dark btn-lg mt-4" type="submit">퇴근 하기</button>
						</form>
					</div>
					<c:if test="${not empty duplicateMessage}">
						<div class="mt-3" style="color: red;">
							<p>${duplicateMessage}</p>
						</div>
					</c:if>

				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/footer/footer.jsp"%>
</body>
</html>