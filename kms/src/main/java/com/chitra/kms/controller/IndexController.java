package com.chitra.kms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public ModelAndView showHome(){		
		return new ModelAndView("redirect:home");		
	}
	
	@RequestMapping(value="/test")
	public String showTest(){
		
		return "/admin/test";
	}
}
