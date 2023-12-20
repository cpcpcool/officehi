<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<div class="header-container">
		<div class="header-left">
			<h1 class="logo-box">
				<a href="${context}main">
					<img src="${resPath}/img/OfficeHi-logo.svg" alt="오피스하이 로고">
				</a>
			</h1>
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
			<form action="${context}logout" method="post">
				<button type="submit" > <span>로그아웃</span> </button>
			</form>
		</div>
	</div>
</header>