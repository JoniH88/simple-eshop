package com.simpleeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@RequestMapping
	public String adminMenu(Model model) {
		return "admin_menu";
	}
}
