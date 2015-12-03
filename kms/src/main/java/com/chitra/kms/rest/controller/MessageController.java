package com.chitra.kms.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitra.kms.domain.test.Message;

@RestController
public class MessageController {
	
	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player){
		
		Message msg = new Message(player, "Hello" + player);
		
		return msg;
	}

}
