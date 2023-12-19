<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<style type="text/css">




</style>
</head>
<body>
	<header>
		<div class="header-container">
			<div class="header-left">
				<div class="logo-box">
					<a href="#">
						<img src="${resPath}/img/OfficeHi-logo.svg" alt="오피스하이 로고">
					</a>
				</div>
				<ul class="header-menu">
					<li>
						<a href="#">공지사항</a>
					</li>
					<li>
						<a href="#">전자 결재</a>
					</li>
					<li>
						<a href="#">근태 관리</a>
					</li>
					<li>
						<a href="#">마이페이지</a>
					</li>
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
					<li>
						<span>공지사항</span>
						<ul>
							<li>
								<span>공지사항 조회</span>
							</li>
						</ul>
					</li>
					<li>
						<span>전자 결재</span>
						<ul>
							<li>
								<span>결재 현황 조회</span>
							</li>
							<li>
								<span>결재 문서 작성</span>
							</li>
						</ul>
					</li>
					<li>
						<span>근태 관리</span>
						<ul>
							<li>
								<span>출퇴근 시간 기록</span>
							</li>
							<li>
								<span>근무 시간 확인</span>
							</li>
						</ul>
					</li>
					<li>
						<span>마이페이지</span>
					</li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>결재 현황 조회</h2>
					<table>
						<thead>
							<tr>
								<th>기안자</th>
								<th>문서 제목</th>
								<th>부서</th>
								<th>기안일</th>
								<th>완료일</th>
								<th>수정/삭제</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>홍길동</td>
								<td>2023-12-24 휴가신청 홍길동 </td>
								<td>마케팅</td>
								<td>2023.12.14</td>
								<td>2023.12.14</td>
								<td>수정/삭제</td>
							</tr>
							<tr>
								<td>홍길동</td>
								<td>2023-12-24 휴가신청 홍길동 </td>
								<td>마케팅</td>
								<td>2023.12.14</td>
								<td>2023.12.14</td>
								<td>수정/삭제</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<footer>
		<div class="footer-top">
			<div class="footer-container">
				<ul class="footer-menu">
					<li>
						<a href="#">공지사항</a>
					</li>
					<li>
						<a href="#">전자 결재</a>
					</li>
					<li>
						<a href="#">근태 관리</a>
					</li>
					<li>
						<a href="#">마이페이지</a>
					</li>
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