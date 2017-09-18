package com.emis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.emis.dao.SysManageDao;
import com.emis.service.SysManageService;
import com.emis.sys.entity.SysMenu;
import com.emis.sys.entity.SysRole;
import com.emis.sys.entity.SysRoleMenu;
import com.emis.sys.entity.SysUserRole;
import com.emis.util.Search;

/**
 * 
 * @author Administrator
 *
 */
@Transactional(readOnly = false)
@Service
public class SysManageServiceImpl implements SysManageService {

	@Resource
	private SysManageDao sysManageDao ;
	
	/**
	 * 获得全部菜单
	 */
	@Override
	public List<SysMenu> getAllMenu(int page,int rows) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>() ;
		map.put("page", page) ;
		map.put("rows", rows) ;
		return sysManageDao.getAllMenu(map);
	}
	
	
	/**
	 * 获得全部菜单
	 */
	@Override
	public List<SysMenu> getAllMenu(Search search) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>() ;
		map.put("page", search.getPage()) ;
		map.put("rows", search.getRows()) ;
		return sysManageDao.getAllMenu(map);
	}

	

	/**
	 * 获得角色菜单
	 */
	@Override
	public List<SysMenu> getMenus(int pid, int uid) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>() ;
		
		map.put("uid", uid) ;

		if(pid != -1){
			map.put("pid", pid) ;
		}
		return sysManageDao.getMenus(map);
	}

	

	
	public SysManageDao getSysManageDao() {
		return sysManageDao;
	}

	public void setSysManageDao(SysManageDao sysManageDao) {
		this.sysManageDao = sysManageDao;
	}



	/*
	 * 获得菜单总数(non-Javadoc)
	 * @see com.emis.service.SysManageService#getMenuTotal()
	 */
	@Override
	public int getMenuTotal() {
		// TODO Auto-generated method stub
		return sysManageDao.getMenuTotal();
	}



	/*
	 * 添加菜单(non-Javadoc)
	 * @see com.emis.service.SysManageService#addMenu(com.emis.sys.entity.SysMenu)
	 */
	@Override
	public int saveMenu(SysMenu menu) {
		// TODO Auto-generated method stub
		if(menu.getId() == 0){
			return sysManageDao.addMenu(menu) ;
		}else{
			
		}
		return 0;
	}



	@Override
	public List<SysRole> getRoles(int page, int rows) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>() ;
		map.put("page", page) ;
		map.put("rows", rows) ;
		return sysManageDao.getRoles(map);
	}



	@Override
	public int getRoleTotal() {
		// TODO Auto-generated method stub
		return sysManageDao.getRoleTotal();
	}



	/*
	 * 保存角色(non-Javadoc)
	 * @see com.emis.service.SysManageService#saveRole(com.emis.sys.entity.SysRole)
	 */
	@Override
	public int saveRole(SysRole role) {
		// TODO Auto-generated method stub
		int res = 0 ;
		
		if(role.getId() == 0){
			res = sysManageDao.addRole(role) ;
		}else{
			res = sysManageDao.updateRole(role) ;
		}
		
		return res ;
	}



	/*
	 * (non-Javadoc)获取角色菜单树
	 * @see com.emis.service.SysManageService#getRoleMenu(int)
	 */
	@Override
	public List<Map<String, Object>> getRoleMenu(int rid) {
		// TODO Auto-generated method stub
		return sysManageDao.getRoleMenu(rid);
	}



	/*
	 * 更新权限(non-Javadoc)
	 * @see com.emis.service.SysManageService#updateRoleMenu(int, java.util.List)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public int updateRoleMenu(int rid, String[] strs) {
		// TODO 更新权限

		List<SysRoleMenu> list = new ArrayList<SysRoleMenu>() ;
		
		for(String str : strs){
			SysRoleMenu srm = new SysRoleMenu() ;
			srm.setRid(rid);
			srm.setMid(Integer.valueOf(str));
			
			list.add(srm) ;
		}
		
		//删除权限
		sysManageDao.removeRoleMenuByRid(rid) ;
		
		//添加权限
		int res = sysManageDao.addRoleMenuByRid(list) ;
		
		return res ;
	}



	/*
	 * 获得用户角色(non-Javadoc)
	 * @see com.emis.service.SysManageService#getUserRole(int)
	 */
	@Override
	public List<Map<String, Object>> getUserRole(int uid) {
		// TODO Auto-generated method stub
		return sysManageDao.getUserRole(uid);
	}



	/*
	 * 更新用户角色(non-Javadoc)
	 * @see com.emis.service.SysManageService#updateUserRole(int, java.lang.String[])
	 */
	@Override
	public int updateUserRole(int uid, String[] strs) {
		// TODO 更新用户角色
		
		List<SysUserRole> list = new ArrayList<SysUserRole>() ;
		
		for(String str : strs){
			SysUserRole sur = new SysUserRole() ;
			sur.setRid(Integer.valueOf(str));
			sur.setUid(uid);
			
			list.add(sur) ;
		}
		
		//删除权限
		sysManageDao.removeUrseRoleByRid(uid) ;
		
		//添加权限
		int res = sysManageDao.addUserRoleByRid(list) ;
		
		return res ;
	}



	/*
	 * 获得角色实体(non-Javadoc)
	 * @see com.emis.service.SysManageService#getRoleEntity(int)
	 */
	@Override
	public SysRole getRoleEntity(int id) {
		// TODO Auto-generated method stub
		return sysManageDao.getRoleEntity(id);
	}

}
