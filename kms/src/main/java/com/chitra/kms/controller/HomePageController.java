package com.chitra.kms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chitra.kms.utils.SSOIdUtil;

@Controller
public class HomePageController {
	SSOIdUtil sSOIdUtil = new SSOIdUtil();
	/**
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
    	model.addAttribute("user", sSOIdUtil.getPrincipal());
        return "/pages/welcome";
    }

}
