package com.emis.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emis.dao.SysUserDao;
import com.emis.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Resource
	SysUserDao sysUserDao ;

	public SysUserDao getSysUserDao() {
		return sysUserDao;
	}

	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}
	
	
}
