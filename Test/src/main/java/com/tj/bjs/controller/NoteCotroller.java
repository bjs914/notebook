package com.tj.bjs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tj.bjs.domain.Memo;
import com.tj.bjs.service.MemoService;

@Controller

public class NoteCotroller {
	@Autowired
	MemoService memoService;
	
	@RequestMapping("/")
	public String welcome(Model model) {
	
		model.addAttribute("note","복정수 노트");
		model.addAttribute("text","지금 당신의 기분은?");
		Memo memo=new Memo();
		List<Memo> memoList=memoService.getAllContents();
		model.addAttribute("memo",memo);
		model.addAttribute("memoList",memoList);
		return "notebook";
	}
	
//	@RequestMapping("/result")
//	public String result(Model model) {
//		model.addAttribute("content",memoService.getAllContents());
//		return "notebookResult";
//	}
	
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String insert(@ModelAttribute("memo") Memo memo, Model model) {
		try {
		memoService.insert(memo);		
		}catch(DataAccessException e) {
			return "notebook";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	public String deleteMemo(@RequestParam("deleteMemo") Memo memo, Model model, String number) {
		memoService.delete(number);
		return "redirect:/";
		
	}
}
