package com.ldh.spring.security.rest;

import javax.annotation.Resource;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("demo")
public class DemoController {
	
	@Resource
	PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		
	}
	
	@RequestMapping("/test")
	public String test(){
		
		return "hamapi";
	}
	
	@RequestMapping("/getPassword")
	public String getPassword(String password){
		
		System.out.println(password);
		
		return passwordEncoder.encode(password);
	}

}
