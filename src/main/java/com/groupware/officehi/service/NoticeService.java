package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author 정유진
 * @editDate 23.12.18 ~ 23.12.19
 * 
 * @author 이승준	+검색 기능 23.12.24 ~ 23.12.26	+수정/삭제 기능 23.12.26 ~ 23.12.27
 * +페이지네이션 23.12.28 ~ 23.12.28
 */

@Service
@RequiredArgsConstructor
public class NoticeService {

	private final NoticeRepository noticeRepository;

	public void insertNotice(NoticeDTO notice) {
		noticeRepository.insert(notice);
	}

	public List<NoticeDTO> findAll() {
		return noticeRepository.findAll();
	}

	public Optional<NoticeDTO> findByNoticeNo(Long noticeNo) {
		return noticeRepository.findByNoticeNo(noticeNo);
	}

	public List<NoticeDTO> findNoticePaging(Paging paging) {
		return noticeRepository.findNoticePaging(paging);
	}

	/* 검색 기능 */
	public List<NoticeDTO> findAllByTitle(String title) {
		return noticeRepository.findAllByTitle(title);
	}

	public List<NoticeDTO> findAllByContent(String content) {
		return noticeRepository.findAllByContent(content);
	}

	public List<NoticeDTO> findAllByNoticeNo(Long noticeNo) {
		return noticeRepository.findAllByNoticeNo(noticeNo);
	}

	/* 수정/삭제 기능 */
	public void updateNoticeInfo(NoticeDTO notice) {
		noticeRepository.update(notice);
	}

	public int deleteNotice(Long noticeNo) {
		return noticeRepository.delete(noticeNo);
	}
	
	/* 페이지네이션 */
	public List<NoticeDTO> findAllPaging(Paging paging) {
		return noticeRepository.findAllPaging(paging);
	}
	
	public List<NoticeDTO> findAllByTitlePaging(String title, Paging paging) {
		return noticeRepository.findAllByTitlePaging(title, paging);
	}

	public List<NoticeDTO> findAllByContentPaging(String content, Paging paging) {
		return noticeRepository.findAllByContentPaging(content, paging);
	}

	public List<NoticeDTO> findAllByNoticeNoPaging(Long noticeNo, Paging paging) {
		return noticeRepository.findAllByNoticeNoPaging(noticeNo, paging);
	}
	
}