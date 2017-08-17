package com.emis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emis.dao.SysManageDao;
import com.emis.service.SysManageService;
import com.emis.sys.entity.SysMenu;
import com.emis.sys.entity.SysRole;

/**
 * 
 * @author Administrator
 *
 */
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
	 * 获得角色菜单
	 */
	@Override
	public List<SysMenu> getMenus(int pid, int rid) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>() ;
		map.put("pid", pid) ;
		map.put("rid", rid) ;

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
		if(role.getId() == 0){
			sysManageDao.addRole(role) ;
		}else{
			
		}
		
		return 0;
	}

}
