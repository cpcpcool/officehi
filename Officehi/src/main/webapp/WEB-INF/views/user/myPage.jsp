<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.ico'/>" />
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/header.css" rel="stylesheet">
<link href="${resPath}/css/footer.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<style>
a {
	color: #222;
}
h2 {
	margin-bottom: 40px;
}

.btn {
	color: #222;
	border: 1px solid #c7c7c7;
}

.notice-content {
	margin: 40px 0 10px 0;
}

.date-box {
	width: 25%;
	height: 30px;
	border: 1px solid #c7c7c7;
	border-radius: 7px;
}

.title-box {
	width: 100%;
	height: 30px;
	border: 1px solid #c7c7c7;
	border-radius: 7px;
}

input {
	width: 220px;
	height: 35px;
	padding: 7px 0 7px 15px;
	border-radius: 7px;
	border: 1px solid #c7c7c7;
}

.text-left {
	width: 250px;
}

td {
	width: 350px;
}
</style>
</head>
<body>
	<header>
		<div class="header-container">
			<div class="header-left">
				<div class="logo-box">
					<a href="#"> <img src="${resPath}/img/OfficeHi-logo.svg" alt="오피스하이 로고">
					</a>
				</div>
				<ul class="header-menu">
					<li><a href="${context}notices">공지사항</a></li>
					<li><a href="${context}approvals">전자 결재</a></li>
					<li><a href="${context}works">근태 관리</a></li>
					<li><a href="${context}mypage">마이페이지</a></li>
				</ul>
			</div>
			<div class="header-right">
				<a href="#"><span>로그아웃</span></a>
			</div>
		</div>
	</header>

	<main>
		<div class="main-container">
			<div class="aside-box">
				<ul class="aside floating">
					<li><span>공지사항</span>
						<ul>
							<li><span><a href="${context}notices">공지사항 조회</a></span></li>
						</ul></li>
					<li><span>전자 결재</span>
						<ul>
							<li><span><a href="${context}approvals">결재 현황 조회</a></span></li>
							<li><span><a href="${context}approvals/add">결재 문서 작성</a></span></li>
						</ul></li>
					<li><span>근태 관리</span>
						<ul>
							<li><span><a href="${context}works">출퇴근 시간 기록</a></span></li>
							<li><span><a href="${context}works/list">근무 시간 확인</a></span></li>
						</ul></li>
					<li><span><a href="${context}mypage">마이페이지</a></span></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>마이 페이지</h2>
					<hr>
					<table>
						<tr>
							<th class="text-left">사번</th>
							<td><input type="text" name="user_no" id="user_no" value="${myPages.userNo}" readonly></td>
							<th class="text-left">이름</th>
							<td><input type=text name=name id="name" value="${myPages.name}"readonly></td>
						</tr>
						<tr>
							<th class="text-left">휴대폰 번호</th>
							<td><input type=text name=phone id="phone" value="${myPages.phone}" readonly></td>
							<th class="text-left">생년월일</th>
							<td><input type=text name=birth_date id="birth_date" value="${myPages.birthDate}" readonly></td>
						</tr>
						<tr>
							<th class="text-left">인감 이미지 경로</th>
							<td><input type=text name=stamp id="stamp" value="${myPages.stamp}" readonly></td>
							<th class="text-left">프로필 이미지 경로</th>
							<td><input type=text name=profile id="profile" value="${myPages.profile}" readonly></td>
						</tr>
						<tr>
							<th class="text-left">입사일</th>
							<td><input type=text name=to_date id="to_date" value="${myPages.toDate}" readonly></td>
							<th class="text-left">퇴사일</th>
							<td><input type=text name=from_date id="from_date" value="${myPages.fromDate}" readonly></td>
						</tr>
						<tr>
							<th class="text-left">부서명</th>
							<td><input type=text name=dept_name id="dept_name" value="${myPages.deptName}" readonly></td>
							<th class="text-left">직급</th>
							<td><input type=text name=position id="position" value="${myPages.position}" readonly></td>
					</table>
					<div class="btn_area">
						<button type="button" class="btn btn-outline-Secondary mt-5 ps-3 pe-3 py-1" onclick="history.go(-1); return false;">뒤로 가기</button>
					</div>
				</div>
			</div>
		</div>
	</main>

	<footer>
		<div class="footer-top">
			<div class="footer-container">
				<ul class="footer-menu">
					<li><a href="${context}notices">공지사항</a></li>
					<li><a href="${context}approvals">전자 결재</a></li>
					<li><a href="${context}works">근태 관리</a></li>
					<li><a href="${context}mypage">마이페이지</a></li>
				</ul>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="footer-container">
				<div>
					<img src="${resPath}/img/OfficeHi-logo.svg" alt="오피스하이 로고">
				</div>
				<p>Copyright &copy; OfficeHi, All right reserved</p>
			</div>
		</div>
	</footer>
</body>
</html>