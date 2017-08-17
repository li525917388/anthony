package com.emis.dao;

import java.util.List;
import java.util.Map;

import com.emis.sys.entity.SysMenu;
import com.emis.sys.entity.SysRole;

/**
 * 后台管理数据连接接口
 * @author Administrator
 *
 */
public interface SysManageDao {

	
	/**
	 * 获得全部菜单
	 * @return
	 */
	public List<SysMenu> getAllMenu(Map<String,Integer> map) ;
	
	
	
	/**
	 * 获得菜单总数
	 * @return
	 */
	public int getMenuTotal() ;
	
	
	
	/**
	 * 添加菜单
	 * @param menu
	 * @return
	 */
	public int addMenu(SysMenu menu) ;
	
	
	
	/**
	 * 获得角色菜单
	 * @param map
	 * @return
	 */
	public List<SysMenu> getMenus(Map<String,Integer> map) ;
	
	
	
	/**
	 * 获得角色
	 * @param map
	 * @return
	 */
	public List<SysRole> getRoles(Map<String,Integer> map) ;
	
	
	/**
	 * 获得角色总数
	 * @return
	 */
	public int getRoleTotal() ;
	
	
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public int addRole(SysRole role) ;
}
