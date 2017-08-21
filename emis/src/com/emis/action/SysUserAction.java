package com.emis.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emis.sys.entity.SysUser;
import com.emis.util.JqGridView;
import com.emis.util.Search;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("sys/user")
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
	
	
	/**
	 * 获得用户列表
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="getUsers", method = { RequestMethod.POST, RequestMethod.GET})
	public void getUsers(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		
		Search search = new Search() ;
		search.setPage(0);
		search.setRows(10) ;
		JqGridView<SysUser> gridView = sysUserService.getUsersAndCount(search) ;
		
		String json = JSONObject.fromObject(gridView).toString() ;
		
		response.getWriter().write(json);
	}
}
