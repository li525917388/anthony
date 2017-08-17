package com.emis.service;

import java.util.List;


import com.emis.sys.entity.SysMenu;
import com.emis.sys.entity.SysRole;

/**
 * 后台管理业务逻辑接口
 * @author Administrator
 *
 */
public interface SysManageService {

	/**
	 * 获得全部菜单
	 * @return
	 */
	public List<SysMenu> getAllMenu(int page,int rows) ;
	
	
	
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
	public int saveMenu(SysMenu menu) ;
	
	
	/**
	 * 获得角色菜单
	 * @param map
	 * @return
	 */
	public List<SysMenu> getMenus(int pid, int rid) ;
	
	
	
	/**
	 * 获得角色
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<SysRole> getRoles(int page,int rows) ;
	
	
	
	/**
	 * 获得菜单总数
	 * @return
	 */
	public int getRoleTotal() ;
	
	
	
	/**
	 * 保存角色
	 * @param role
	 * @return
	 */
	public int saveRole(SysRole role) ;
}
