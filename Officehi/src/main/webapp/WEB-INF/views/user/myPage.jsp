<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="context" value="/" />
<c:url var="resPath" value="/resources" />
<!--  
* @author 정유진
 * @editDate 23.12.20 ~ 23.12.21 
 -->
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
	<%@ include file="../header/header.jsp"%>
	<main>
		<div class="main-container">
			<%@ include file="../aside/userAside.jsp"%>
			<div class="main-box">
				<div class="content-box floating">
					<h2>마이 페이지</h2>
					<hr>
						<table>
						<tr>
							<th class="text-left">사번</th>
							<td><input type="text" name="user_no" id="user_no" value="${loginUser.userNo}" readonly></td>
							<th class="text-left">이름</th>
							<td><input type=text name=name id="name" value="${mypageuser.name}" readonly></td>
						</tr>
						<tr>
							<th class="text-left">휴대폰 번호</th>
							<td><input type=text name=phone id="phone" value="${mypageuser.phone}" readonly></td>
							<th class="text-left">생년월일</th>
							<td><input type=text name=birth_date id="birth_date" value="${mypageuser.birthDate}" readonly></td>
						</tr>
						<tr>
							<th class="text-left">인감 이미지 경로</th>
							<td><input type=text name=stamp id="stamp" value="${mypageuser.stamp}" readonly></td>
							<th class="text-left">프로필 이미지 경로</th>
							<td><input type=text name=profile id="profile" value="${mypageuser.profile}" readonly></td>
						</tr>
						<tr>
							<th class="text-left">입사일</th>
							<td><input type=text name=to_date id="to_date" value="${mypageuser.toDate}" readonly></td>
							<th class="text-left">퇴사일</th>
							<td><input type=text name=from_date id="from_date" value="${mypageuser.fromDate}" readonly></td>
						</tr>
						<tr>
							<th class="text-left">부서명</th>
							<td><input type=text name=dept_name id="dept_name" value="${mypageuser.deptName}" readonly></td>
							<th class="text-left">직급</th>
							<td><input type=text name=position id="position" value="${mypageuser.position}" readonly></td>
					</table>
					<div class="btn_area">
						<button type="button" class="btn btn-white btn-outline-dark btn-small mt-3" onclick="history.go(-1); return false;">뒤로 가기</button>
					</div>
				</div>
			</div>
		</div>
	</main>

	<%@ include file="../footer/footer.jsp"%>
</body>
</html>