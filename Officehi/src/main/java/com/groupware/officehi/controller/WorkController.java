package com.groupware.officehi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.officehi.dto.Work;
import com.groupware.officehi.repository.WorkRepository;


@Controller
public class WorkController {
	
	private final WorkRepository workRepository;
	
	public WorkController(WorkRepository workRepository) {
		this.workRepository = workRepository;
	}

	@GetMapping("/works")
	public String workTime(Model model) {
		List<Work> works = workRepository.workTimes();
		model.addAttribute("works", works);
		return "/user/works/workTime";
	}
	
	@PostMapping("/works/arrival")
	public String arrival(){
		
		return "redirect:/works";
	}
	
	@PostMapping("/works/arrival")
	public String leave(){
		
		return "redirect:/works";
	}
	
	@GetMapping("/works/list")
	public String workList() {
		return "/user/works/workList";
	}
	
}
