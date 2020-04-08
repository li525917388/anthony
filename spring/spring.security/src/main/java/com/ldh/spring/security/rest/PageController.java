package com.ldh.spring.security.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping("/login")
	public String login(){
		
		System.out.println("登录");
		
		return "login";
	}
}
