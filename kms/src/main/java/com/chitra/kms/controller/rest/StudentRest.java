package com.chitra.kms.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.kms.service.StudentService;

@RestController
@RequestMapping("/admin")
public class StudentRest {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = { "/student"}, method = RequestMethod.GET ,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findAllStudnet() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> students = new HashMap<String, Object>();
		students.put("STUDENT", studentService.findAll());
		map.put("MESSAGE", students);
		
		return map;
	}

}
