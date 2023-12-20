<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="resPath" value="/resources" />
<c:url var="context" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오피스하이 - 메인</title>
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<link href="${resPath}/css/layout-sub.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<style type="text/css"></style>
</head>
<body id="main">
	<%@ include file="../header/header.jsp" %>
	<main>
		<div class="main-container">
			<div class="aside-box">
				<div class="aside floating">
					<div class="profile-box">
						<div class="profile-image-box">
							<%-- <img src="${user.profile}" alt="프로필 이미지"> --%>
							<img src="${resPath}/img/calender.svg" alt="프로필 이미지">
						</div>
						<span>영업부</span>
						<p><span>이미자</span> <span>팀장</span></p>
					</div>
				</div>
				<div class="aside floating quick-menu-bar">
					<div class="quick-menu">
						<div class="quick-icon-box">
							<img src="${resPath}/img/mypage.svg" alt="마이페이">
						</div>
						<span>마이페이지</span>
					</div>
					<div class="quick-menu">
						<div class="quick-icon-box">
							<img src="${resPath}/img/approval.svg" alt="전자 결재">
						</div>
						<span>전자 결재</span>
					</div>
					<div class="quick-menu mt">
						<div class="quick-icon-box">
							<img src="${resPath}/img/work.svg" alt="근태 관리">
						</div>
						<span>근태 관리</span>
					</div>
					<div class="quick-menu mt">
						<div class="quick-icon-box">
							<img src="${resPath}/img/notice.svg" alt="공지사항">
						</div>
						<span>공지사항</span>
					</div>
				</div>
			</div>
			<div class="main-box">
				<div class="notice-wrapper">
					<div class="notice-box floating">공지사항</div>
					<div class="notice-title floating">편리하고 효율적인 그룹웨어 OfficeHi 모두 이용해 주세요!</div>
				</div>
				<div class="content-box-wrapper">
					<div class="content-box wrapping-2 floating">
						<h3>결재 현황</h3>
						<table>
							<tbody>
								<tr>
									<td>홍길동</td>
									<td>2023-12-24 휴가신청 홍길동 </td>
									<td>2023.12.14</td>
								</tr>
								<tr>
									<td>홍길동</td>
									<td>2023-12-24 휴가신청 홍길동 </td>
									<td>2023.12.14</td>
								</tr>
								<tr>
									<td>홍길동</td>
									<td>2023-12-24 휴가신청 홍길동 </td>
									<td>2023.12.14</td>
								</tr>
								<tr>
									<td>홍길동</td>
									<td>2023-12-24 휴가신청 홍길동 </td>
									<td>2023.12.14</td>
								</tr>
								<tr>
									<td>홍길동</td>
									<td>2023-12-24 휴가신청 홍길동 </td>
									<td>2023.12.14</td>
								</tr>
								<tr>
									<td>홍길동</td>
									<td>2023-12-24 휴가신청 홍길동 </td>
									<td>2023.12.14</td>
								</tr>
								<tr>
									<td>홍길동</td>
									<td>2023-12-24 휴가신청 홍길동 </td>
									<td>2023.12.14</td>
								</tr>
							</tbody>
						</table>
						<div class="link-box approvals">
							<a href="${context}approvals">
								<span>결재 문서 더보기</span>
							</a>
						</div>
					</div>
					<div class="content-box wrapping-2 floating">
						<h3>근태 관리</h3>
						<div class="time-box">
							<span>16:54:02</span>
						</div>
						<form action="" method="post">
							<div class="work-btn-box">
								<button type="submit" class="start-btn">출근</button>
								<button type="submit" class="end-btn">퇴근</button>
							</div>
						</form>
						<div class="link-box works">
							<a href="${context}works">
								<span>근무시간 확인</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="../footer/footer.jsp" %>
</body>
</html>