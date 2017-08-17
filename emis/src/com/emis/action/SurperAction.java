package com.emis.action;

import javax.annotation.Resource;

import com.emis.service.SysUserService;

public class SurperAction {

	@Resource
	SysUserService sysUserService ;

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	
	
}
