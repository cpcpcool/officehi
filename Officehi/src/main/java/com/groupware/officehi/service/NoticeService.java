package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.repository.NoticeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	public NoticeService(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}
	
	public void insertNotice(NoticeDTO notice) {
		noticeRepository.insertNotice(notice);
	}
	public List<NoticeDTO> findAll(){
		return noticeRepository.findAll();
	}
	
	public List<NoticeDTO> findByContent(String content){
		return noticeRepository.findByContent(content);
	}
	
	public Optional<NoticeDTO> findById(Long noticeNo){
		return noticeRepository.findById(noticeNo);
	}
}
