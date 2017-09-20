package com.emis.service;


import com.emis.sys.entity.SysUser;
import com.emis.util.JqGridView;
import com.emis.util.Search;

public interface SysUserService {

	
	
	/**
	 * 获得用户列表
	 * @param map
	 * @return
	 */
	public JqGridView<SysUser> getUsersAndCount(Search search) ;
	
	
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public SysUser login(SysUser user) ;
}
