<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 조회</title>
<link rel="icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.ico'/>" />
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/gh/sun-typeface/SUIT/fonts/static/woff2/SUIT.css" rel="stylesheet">
<link href="${resPath}/css/reset.css" rel="stylesheet">
<link href="${resPath}/css/layout.css" rel="stylesheet">
<style>
h2 {
	margin-bottom: 40px;
}

.aside ul span.selected {
	font-weight: 800;
	color: #345de3;
}
.notice-content {
	margin: 40px 0 10px 0;
}

.date-box {
	width: 25%;
	height: 30px;
	border: 1px solid #c2c2c2;
	border-radius: 7px;
}

.title-box {
	width: 100%;
	height: 30px;
	border: 1px solid #c2c2c2;
	border-radius: 7px;
}
</style>
</head>
<body>
	<%@ include file="../../header/header.jsp"%>
	<main>
		<div class="main-container">
			<%@ include file="../../aside/userAside.jsp" %>
			<div class="main-box">
				<div class="content-box floating">
					<h2>공지사항 조회</h2>
					<table>
						<tr>
							<th width=10% class="text-left">제목</th>
							<td width=90%><input type=text name=subject id="subject" style="width:100%; height:35px; padding:7px 0 7px 15px; border-radius:7px; border:1px solid #c2c2c2;" value="${notice.title}" readonly="readonly"></td>
						</tr>
						<tr>
							<th width=10% class="text-left">등록일</th>
							<td width=90%><input type="text" id="id" style="height:35px; padding:7px 0 7px 15px; border-radius:7px; border:1px solid #c2c2c2;" value="${notice.date}" readonly="readonly"></td>
						</tr>
					</table>
					<label class="notice-content">내용</label>
					<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" style="height:300px;" readonly="readonly" >${notice.content}</textarea>
					<div class="btn_area">
						<a class="btn btn-white btn-outline-dark btn-small mt-3" onClick="history.back()">뒤로 가기</a>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="../../footer/footer.jsp"%>
</body>
</html>