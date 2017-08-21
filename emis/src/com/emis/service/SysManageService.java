package com.emis.service;

import java.util.List;
import java.util.Map;

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
	public List<SysMenu> getMenus(int pid, int uid) ;
	
	
	
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
	 * 获得角色实体
	 * @param id
	 * @return
	 */
	public SysRole getRoleEntity(int id) ;
	
	/**
	 * 保存角色
	 * @param role
	 * @return
	 */
	public int saveRole(SysRole role) ;
	
	
	
	
	/**
	 * 获得角色菜单树
	 * @param rid
	 * @return
	 */
	public List<Map<String,Object>> getRoleMenu (int rid) ;
	
	
	
	/**
	 * 更新权限
	 * @param rid
	 * @param list
	 * @return
	 */
	public int updateRoleMenu (int rid, String[] str) ;
	
	
	
	/**
	 * 获得用户角色树
	 * @param rid
	 * @return
	 */
	public List<Map<String,Object>> getUserRole (int uid) ;
	
	
	
	/**
	 * 更新用户角色
	 * @param rid
	 * @param list
	 * @return
	 */
	public int updateUserRole (int uid, String[] str) ;
}
