<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 관리</title>
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

.table-group-divider tr td a {
	color: #222;
}

.pagination nav ul li a {
	color: #222;
}
</style>
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
							<li><a href=""><span class="selected">공지사항 관리</span></a></li>
						</ul></li>
				</ul>
			</div>
			<div class="main-box">
				<div class="content-box floating">
					<h2>공지사항 관리</h2>
					<form action="" role="search">
						<div class="row g-2 align-items-center mb-3" id="noticeSearch" >
							<div class="col-3">
								<select class="form-select" aria-label="Default select example">
									<option selected>제목</option>
									<option value="1">공지 번호</option>
									<option value="2">등록일</option>
								</select>
							</div>
							<div class="col-5">
								<input class="form-control col-auto" type="text" placeholder="검색 키워드를 입력하세요" aria-label="관리자 공지 검색">
							</div>
							<div class="col-auto">
								<button class="btn btn-dark" type="submit">검색</button>
							</div>
						</div>
					</form>

					<!-- 등록버튼 -->
					<div>
						<button class="btn btn-dark" type="button" onclick="location.href='${context}admin/notices/add'">공지사항 등록</button>
					</div>

					<!-- 리스트 -->
					<table class="table mt-3">
						<thead>
							<tr>
								<th scope="col">공지 번호</th>
								<th scope="col">제목</th>
								<th scope="col">등록일</th>
							</tr>
						</thead>
						<tbody class="table-group-divider">
							<tr>
								<td><a href="${context}admin/notices/1">1</a></td>
								<td><a href="${context}admin/notices/1">이승준의 완벽한 레이아웃에 대한 찬사</a></td>
								<td><a href="${context}admin/notices/1">2023-12-18</a></td>
							</tr>
							<tr>
								<td><a href="${context}admin/notices/1">2</a></td>
								<td><a href="${context}admin/notices/1">이승준의 완벽한 레이아웃에 대한 찬사</a></td>
								<td><a href="${context}admin/notices/1">2023-12-18</a></td>
							</tr>
							<tr>
								<td><a href="${context}admin/notices/1">3</a></td>
								<td><a href="${context}admin/notices/1">이승준의 완벽한 레이아웃에 대한 찬사</a></td>
								<td><a href="${context}admin/notices/1">2023-12-18</a></td>
							</tr>
							<tr>
								<td><a href="${context}admin/notices/1">4</a></td>
								<td><a href="${context}admin/notices/1">이승준의 완벽한 레이아웃에 대한 찬사</a></td>
								<td><a href="${context}admin/notices/1">2023-12-18</a></td>
							</tr>
						</tbody>
					</table>

					<!-- 페이지네이션 -->
					<div class="pagination d-flex justify-content-center mt-2">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>