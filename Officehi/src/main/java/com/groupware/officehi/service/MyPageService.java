package com.groupware.officehi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.MyPage;
import com.groupware.officehi.repository.MyPageRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyPageService {
	
	private final MyPageRepository mypageRepository;
	
	public MyPageService(MyPageRepository mypageRepository) {
		this.mypageRepository = mypageRepository;
	}
	
	public List<MyPage> findByAll(){
		return mypageRepository.findByAll();
	}
	
}
