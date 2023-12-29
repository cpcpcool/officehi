package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.NoticeDTO;

/**
 * @author 정유진
 * @editDate 23.12.18 ~ 23.12.19
 * 페이지네이션
 * @editDate 23.12.26 ~ 23.12.28
 * 
 * @author 이승준	+검색 기능 23.12.24 ~ 23.12.26	+삭제 기능 23.12.26 ~ 23.12.26
 * +페이지네이션 23.12.28 ~ 23.12.28
 */

@Repository
public interface NoticeRepository {

	void insert(NoticeDTO notice);

	List<NoticeDTO> findAll();

	Optional<NoticeDTO> findByNoticeNo(Long noticeNo);
	
	/* 검색 기능 */
	List<NoticeDTO> findAllByTitle(@Param("title") String title);

	List<NoticeDTO> findAllByContent(@Param("content") String content);

	List<NoticeDTO> findAllByNoticeNo(@Param("noticeNo") Long noticeNo);

	/* 수정/삭제 기능 */
	void update(NoticeDTO notice);
	
	int delete(@Param("noticeNo") Long noticeNo);

	/* 페이지네이션 */
	List<NoticeDTO> findAllPaging(Paging paging);
	
	List<NoticeDTO> findAllByTitlePaging(@Param("title") String title, @Param(value = "paging") Paging paging);

	List<NoticeDTO> findAllByContentPaging(@Param("content") String content, @Param(value = "paging") Paging paging);

	List<NoticeDTO> findAllByNoticeNoPaging(@Param("noticeNo") Long noticeNo, @Param(value = "paging") Paging paging);

}