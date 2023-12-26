<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="aside-box">
	<ul class="aside floating">
		<li><span>공지사항</span>
			<ul>
				<li><a href="${context}notices"><span>공지사항 조회</span></a></li>
			</ul>
		</li>
		<li><span>전자 결재</span>
			<ul>
				<li><a href="${context}approvals"><span>결재 현황 조회</span></a></li>
				<li><a href="${context}approvals/add"><span>결재 문서 작성</span></a></li>
			</ul>
		</li>
		<li><span>근태 관리</span>
			<ul>
				<li><a href="${context}works"><span>출퇴근 시간 기록</span></a></li>
				<li><a href="${context}works/list"><span>근무 시간 확인</span></a></li>
			</ul>
		</li>
		<li>
			<a href="${context}mypage"><span>마이페이지</span></a>
		</li>
	</ul>
</div>