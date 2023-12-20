package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.groupware.officehi.dto.Notice;

@Mapper
public interface NoticeRepository {
	Optional<Notice> findById(Long notice_no);
	List<Notice> findByAll();
}
