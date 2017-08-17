package com.emis.sys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.emis.service.SysManageService;

public class SysSurperAction {

	@Resource
	SysManageService sysManageService ;

	public SysManageService getSysManageService() {
		return sysManageService;
	}

	public void setSysManageService(SysManageService sysManageService) {
		this.sysManageService = sysManageService;
	}
	
}
