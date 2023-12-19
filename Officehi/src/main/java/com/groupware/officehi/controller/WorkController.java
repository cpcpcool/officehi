package com.groupware.officehi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.officehi.dto.Work;
import com.groupware.officehi.repository.WorkRepository;


@Controller
public class WorkController {
	
	private final WorkRepository workRepository;
	
	@Autowired
	public WorkController(WorkRepository workRepository) {
		this.workRepository = workRepository;
	}

	@GetMapping("/works")
	public String workTime() {
		return "/user/works/workTime";
	}
	
	@PostMapping("/works/arrival")
	public String arrival(){
		
		return "redirect:/works";
	}
	
	@PostMapping("/works/leave")
	public String leave(){
		
		return "redirect:/works";
	}
	
	@GetMapping("/works/list")
	public String workList(Model model) {
		List<Work> works = workRepository.workTimes();
		model.addAttribute("works", works);
		return "/user/works/workList";
	}
	
}
