package com.nashtech.assignment.pdh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supcate")
public class SupCategoryController {
	@GetMapping("/")
	public String test() {
		return "Test";
	}
}
