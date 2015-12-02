package com.chitra.kms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public ModelAndView showHome(){		
		return new ModelAndView("redirect:home");		
	}
	
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "/pages/welcome";
    }
}
