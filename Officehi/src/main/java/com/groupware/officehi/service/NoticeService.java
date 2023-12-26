package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author 정유진
 * @editDate 23.12.18 ~ 23.12.19
 * 
 * @author 이승준
 * 검색 기능 추가 23.12.24 ~ 23.12.26
 * 삭제 기능 추가 23.12.26 ~ 23.12.26
 */

@Service
@RequiredArgsConstructor
public class NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	public void insertNotice(NoticeDTO notice) {
		noticeRepository.insert(notice);
	}
	public List<NoticeDTO> findAll(){
		return noticeRepository.findAll();
	}
	
	public Optional<NoticeDTO> findByNoticeNo(Long noticeNo){
		return noticeRepository.findByNoticeNo(noticeNo);
	}
	
	/* 검색 기능 */
	public List<NoticeDTO> searchTitle(String title) {
		return noticeRepository.searchTitle(title);
	}
	
	public List<NoticeDTO> searchContent(String content) {
		return noticeRepository.searchContent(content);
	}
	
	public List<NoticeDTO> searchNoticeNo(Long noticeNo) {
		return noticeRepository.searchNoticeNo(noticeNo);
	}
	public int deleteNotice(Long noticeNo) {
		return noticeRepository.delete(noticeNo);
	}
}