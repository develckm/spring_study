package com.shop.spring_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.spring_study.repository.CateRepository;

@Controller
@RequestMapping("/cate")
public class CateController {
	@Autowired
	CateRepository cr;
	@GetMapping("/list.do")
	public String list(Model m) {
		//System.out.println(cr.findAll());
		//m.addAttribute("cateList",cr.findAll());
		m.addAttribute("cateList",cr.selectAllJPQL());
		
		return "cate/list";
	}
}
