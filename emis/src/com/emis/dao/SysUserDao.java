package com.emis.dao;

import java.util.List;
import java.util.Map;

import com.emis.sys.entity.SysUser;

public interface SysUserDao {

	/**
	 * 获得用户列表
	 * @param map
	 * @return
	 */
	public List<SysUser> getUsers(Map<String,Object> map) ;
	
	
	
	/**
	 * 获得总数
	 * @param map
	 * @return
	 */
	public int getUserTotal (Map<String,Object> map) ;
}
