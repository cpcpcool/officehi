package com.groupware.officehi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/approvals")
	public String approvalView() {
		return "user/approvals/approvalList";
	}
	
	@GetMapping("/approvals/add")
	public String approvalAdd() {
		return "user/approvals/approvalAddForm";
	}
	
	@GetMapping("/works")
	public String worksView() {
		return "user/works/workTime";
	}

	@GetMapping("/works/list")
	public String worksListView() {
		return "user/works/workList";
	}
	
	
	
}
