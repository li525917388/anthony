package com.emis.dao;

import java.util.List;
import java.util.Map;

import com.emis.sys.entity.SysMenu;
import com.emis.sys.entity.SysRole;
import com.emis.sys.entity.SysRoleMenu;
import com.emis.sys.entity.SysUserRole;
import com.emis.util.Search;

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
	 * 获得全部菜单
	 * @return
	 */
	public List<SysMenu> getAllMenuSearch(Search s) ;
	
	
	
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
	 * 获得角色实体
	 * @param id
	 * @return
	 */
	public SysRole getRoleEntity (int id) ;
	
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public int addRole(SysRole role) ;
	
	
	
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public int updateRole(SysRole role) ;
	
	
	
	/**
	 * 获取角色菜单树
	 * @param rid
	 * @return
	 */
	public List<Map<String,Object>> getRoleMenu (int rid) ;
	
	
	
	/**
	 * 删除权限
	 * @param rid
	 * @return
	 */
	public int removeRoleMenuByRid(int rid) ;
	
	
	/**
	 * 添加权限
	 * @param list
	 * @return
	 */
	public int addRoleMenuByRid(List<SysRoleMenu> list) ;
	
	
	/**
	 * 获取用户角色树
	 * @param rid
	 * @return
	 */
	public List<Map<String,Object>> getUserRole (int uid) ;
	
	
	
	/**
	 * 删除用户角色
	 * @param rid
	 * @return
	 */
	public int removeUrseRoleByRid(int uid) ;
	
	
	/**
	 * 添加用户角色
	 * @param list
	 * @return
	 */
	public int addUserRoleByRid(List<SysUserRole> list) ;
}
