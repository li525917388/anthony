package com.emis.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("SysUserAction")
public class SysUserAction extends SurperAction {

	
	/**
	 * 测试
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="test", method = { RequestMethod.POST, RequestMethod.GET})
	public void test(HttpServletRequest request, HttpServletResponse response){
		System.out.println("hello");
	}
}
