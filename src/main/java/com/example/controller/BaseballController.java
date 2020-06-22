package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domani.Baseball;
import com.example.form.FormBaseball;
import com.example.service.BaseballService;


@Controller
@RequestMapping("/")
public class BaseballController {
	@Autowired
	private BaseballService baseballService;
		
	@RequestMapping("")
	public String index(Model model) {
		List<Baseball> baseball = baseballService.findAll();
		model.addAttribute("baseball",baseball);
		System.out.println(baseball.toString());
		
		return "baseballShowList";
	}
	
	@ModelAttribute
	public FormBaseball setUpBaseball() {
		return new FormBaseball();
	}
	@RequestMapping("/baseballList")
	public String showPage(FormBaseball form,Model model) {
		Baseball baseball = baseballService.load(form.getId());
		model.addAttribute("baseball", baseball);
		
		return "baseballList";
	}
	
	
}
