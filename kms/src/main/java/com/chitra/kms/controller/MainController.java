package com.chitra.kms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chitra.kms.entity.User;
import com.chitra.kms.entity.UserProfile;
import com.chitra.kms.service.UserProfileService;
import com.chitra.kms.service.UserService;
 
@Controller
public class MainController { 
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	

	
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
    	model.addAttribute("user", getPrincipal());
        return "/pages/welcome";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }
 
    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
     
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
 
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
    
    @RequestMapping(value="/newUser" , method = RequestMethod.GET)
    public String newRegistration(ModelMap model){
    	User user = new User();
    	model.addAttribute("user",user);
    	return "newuser"; 
    }
    
    @ResponseBody
    @RequestMapping(value="/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user,
    		BindingResult result, ModelMap model){
    	if(result.hasErrors()){
    		System.out.println("There are errors");
    		return "newuser";    		
    	}
    	userService.save(user);
    	//Checking profile
    	if(user.getUserProfiles()!=null){
    		for(UserProfile profile : user.getUserProfiles()){
    			System.out.println("Profile"+ profile.getType());;
    		}
    	}
    	model.addAttribute("success", "User" + user.getFirstName());
    	
    	return "registerationsuccess";
    }
    
     
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
    
    @ModelAttribute("role")
    public List<UserProfile> initializeProfiles(){
    	return userProfileService.findAll();
    }
    
}