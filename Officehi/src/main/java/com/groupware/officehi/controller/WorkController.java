package com.groupware.officehi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WorkController {

	@GetMapping("/works")
	public String workTime() {
		return "/user/works/workTime";
	}
	
	@PostMapping("/works")
	public String commute(){
		
		return "redirect:/works";
	}
	
	@GetMapping("/works/list")
	public String workList() {
		return "/user/works/workList";
	}
	
}
