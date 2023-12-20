<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출퇴근 시간 기록</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="${resPath}/css/layout-sub.css" rel="stylesheet">
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

#localTime {
	margin-top: 30px;
	font-size: 2.5em;
}

.commute1 {
	
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
<body>
	<%@ include file="/WEB-INF/views/header/header.jsp"%>
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
							<li><a href="${context}works"><span class="selected">출퇴근 시간 기록</span></a></li>
							<li><a href="${context}works/list"><span>근무 시간 확인</span></a></li>
						</ul></li>
					<li><span>마이페이지</span></li>
				</ul>
			</div>
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
					<p id="localTime"></p>
					<div class="d-flex">
						<form class="arrival" action="${context}works/arrival" method="post">
							<input type="hidden" name="userNo" value="10002" />
							<button class="btn btn-primary btn-lg mt-4 me-3" type="submit">출근 하기</button>
						</form>
						<form class="leave" action="${context}works/leave" method="post">
							<input type="hidden" name="userNo" value="10002" />
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
<script type="text/javascript">
	// 현재 시간표시 ===============================================
	function updateLocalTime() {
		const currentDateTime = new Date();
		const localTime = currentDateTime.toLocaleTimeString();
		document.getElementById('localTime').innerHTML = localTime;
	}

	// 실시간 업데이트 표시 =========================================	
	window.onload = function() {
		updateLocalTime();
		setInterval(updateLocalTime, 1000);
	}

	// 동일 날짜 중복 메시지 =========================================
</script>
</html>