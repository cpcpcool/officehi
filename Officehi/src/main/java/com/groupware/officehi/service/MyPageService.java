package com.groupware.officehi.service;

/**
 * @author 정유진
 * @editDate 23.12.18 ~23.12.26
 */

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.MyPageDTO;
import com.groupware.officehi.repository.MyPageRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class MyPageService {
	
	private final MyPageRepository myPageRepository;
	
	@Autowired
	public MyPageService(MyPageRepository mypageRepository) {
		this.myPageRepository = mypageRepository;
	}
	
	public Optional<MyPageDTO> findByUserNo(Long userNo){
		return myPageRepository.findByUserNo(userNo);
	}
	
}
