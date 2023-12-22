package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.groupware.officehi.dto.NoticeDTO;

@Mapper
public interface NoticeRepository {
	Optional<NoticeDTO> findById(Long notice_no);
	List<NoticeDTO> findByAll();
}
