package com.groupware.officehi.repository;
/**
 * @author 정유진
 * @editDate 23.12.18 ~23.12.26
 */
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
