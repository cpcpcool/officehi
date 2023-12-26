package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.NoticeDTO;

@Repository
public interface NoticeRepository {
	
	void insert(NoticeDTO notice);
	
	List<NoticeDTO> findAll();
	
	Optional<NoticeDTO> findByNoticeNo(Long noticeNo);
	
	List<NoticeDTO> searchTitle(@Param("title") String title);
	List<NoticeDTO> searchContent(@Param("content") String content);
	List<NoticeDTO> searchNoticeNo(@Param("noticeNo") Long noticeNo);
	
}
