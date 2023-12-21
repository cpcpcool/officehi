<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<link rel="icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.ico'/>" />
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<style type="text/css">
html, body, div, span, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, address, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strong, sub, sup, var,
b, u, i,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header,
nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}
a {
	text-decoration: none;
}
img {
	vertical-align: bottom;
}
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}
.hidden {
	overflow: hidden;
	display: inline-block;
	position: absolute;
	z-index: -1;
	border: 0;
	width: 1px;
	height: 1px;
	clip: rect(1px, 1px, 1px, 1px);
	clip-path: inset(50%);
}
#skip {
	position: relative;
	z-index: 99;
}
#skip > a {
	position: absolute;
	display: block;
	width: 100%;
	height: 35px;
	background: #333;
	color: #fff;
	line-height: 35px;
	text-align: center;
	left: 0;
	top: -35px;
}
#skip > a:focus, #skip > a:active {
	top: 0;
}

input[type="text"], button, select {	
	outline: none;
}

button {
	cursor: pointer;
	border: none;
	padding: 0;
	background-color: transparent;
}


/* ios대응 */
html {
	-webkit-text-size-adjust: none;
	-moz-text-size-adjust: none;
	-ms-text-size-adjust: none;
	-o-text-size-adjust: none;
}
input, button {
	/*-webkit-appearance: none;
	-moz-appearance: none;*/
	appearance: auto;
	-webkit-border-radius:  0;
}
select {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	background: url('../reset/select-arrow.png') no-repeat 99% 45%;

}

select::-ms-expand {
	display: none; 
	/* 화살표없애기 for ie10, 11 */
}



html {
	font-family: 'SUIT', sans-serif;
}
body {
	background-color: #f6f6f6;
}
main {
	padding: 40px 360px;
	font-size: 20px;
}
.main-container {
	display: flex;
}
.main-aside {
}
.aside {
	display: flex;
	flex-wrap: wrap;
	width: 240px;
	min-width: 240px;
	padding: 2em;
	margin-right: 1em;
	background-color: #fff;
}
.main-box {
	width: 100%;
}
.content-box {
	display:flex;
	flex-wrap:wrap;
	flex-direction: column;
	padding: 1.6em;
	background-color: #fff;
}
.floating {
	border-radius: 12px;
	box-shadow: 0px 0px 10px 10px rgba(0, 0, 0, 0.03);
}
.quick-menu {
	width: 50%;
}
.aside {
	font-size: 20px;
}
.aside span {
	font-size: 0.9em;
	font-weight: 700;
	line-height: 1.4;
}
.aside ul li {
	display: flex;
	padding: 0.3em 1em;
}
.aside ul span {
	font-size: 0.8em;
	font-weight: 600;
}
h2 {
	font-size: 24px;
	font-weight: 700;
	margin-bottom: 16px
}
h2 .lgmg {
	margin-botton: 20px;
}
thead {
	border-bottom: 1px solid #c7c7c7;
}
tbody {
	padding-top: 16px;
}
th {
	font-size: 18px;
	font-weight: 700;
}
tr {
	font-size: 16px;
	font-weight: 600;
}
thead tr th{
	padding: 20px 0 16px;
}
tbody tr td{
	padding-top: 20px;
}
tbody tr:first-of-type td {
	padding-top: 16px;
}
</style>
</head>
<body>
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
</body>
</html>