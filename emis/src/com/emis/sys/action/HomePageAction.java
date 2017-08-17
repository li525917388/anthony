package com.emis.sys.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emis.sys.entity.SysMenu;

@Controller
@RequestMapping("home")
public class HomePageAction extends SysSurperAction {

	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="admin", method = { RequestMethod.POST, RequestMethod.GET})
	public String toAdminManage(HttpServletRequest request, HttpServletResponse response){
	
		return "main/manage";
		
	}
	
	
	
	/**
	 * 菜单管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="sysMenu", method = { RequestMethod.POST, RequestMethod.GET})
	public String toSysMenu(HttpServletRequest request, HttpServletResponse response){
		
		return "sys/sysMenu";
	}
	
	
	
	
	/**
	 * 角色管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="sysRole", method = { RequestMethod.POST, RequestMethod.GET})
	public String toSysRole(HttpServletRequest request, HttpServletResponse response){
		
		return "sys/sysRole";
	}
	
	
	
	/**
	 * 用户管理
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="sysUser", method = { RequestMethod.POST, RequestMethod.GET})
	public String toSysUser(HttpServletRequest request, HttpServletResponse response){
		
		return "sys/sysUser";
	}
}
