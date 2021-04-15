package com.tj.bjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class NoteCotroller {

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("note","복정수 노트");
		model.addAttribute("text","지금 당신의 기분은?");
		return "notebook";
	}
}
