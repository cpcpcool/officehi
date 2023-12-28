<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!--
 * @author 박재용
 * @editDate 23.12.21 ~ 23.12.23
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세</title>
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
	<%@ include file="/WEB-INF/views/header/adminHeader.jsp"%>
	<main>
		<div class="main-container">
			<%@ include file="/WEB-INF/views/aside/adminAside.jsp" %>
			<div class="main-box">
				<div class="content-box floating">
					<h2>공지사항 상세</h2>
					<form:form action="${context}admin/notices/${notice.noticeNo}" modelAttribute="notice" method="post">
					<%-- <form action="${context}admin/notices" method="post"> --%>
						<div class="mt-4 mb-4 row g-1 align-items-center">
							<div class="col-1">
								<label for="" class="form-label mb-0">제목</label>
							</div>
							<div class="col-11">
								<form:input path="title" cssClass="form-control" id="noticeName"/>
								<%-- <input type="text" class="form-control" id="noticeName" value="${notice.title}"> --%>
							</div>
						</div>
						<div class="mb-4">
							<label for="noticeContent" class="form-label mb-3">내용</label>
							<form:textarea path="content" class="form-control" id="noticeContent" rows="3" style="height: 400px; resize: none;"/>
						</div>
						<div class="noticeModify">
							<button class="btn btn-dark mt-3 me-3" id="arrival" type="submit">수정 하기</button>
							<button class="btn btn-outline-dark mt-3" id="leave" onclick="history.go(-1)" type="button">뒤로 가기</button>
						</div>
					<!-- </form> -->
					</form:form>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/footer/adminFooter.jsp"%>
</body>
</html>