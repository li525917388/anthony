package com.emis.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emis.dao.SysUserDao;
import com.emis.service.SysUserService;
import com.emis.sys.entity.SysUser;
import com.emis.util.JqGridView;
import com.emis.util.Search;

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

	/*
	 * 获得数据和分页(non-Javadoc)
	 * @see com.emis.service.SysUserService#getUsersAndCount(com.emis.util.Search)
	 */
	@Override
	public JqGridView<SysUser> getUsersAndCount(Search search) {
		// TODO Auto-generated method stub
		JqGridView<SysUser> gridView = new JqGridView<SysUser>() ;
		Map<String,Object> map = new HashMap<String,Object>() ;
		map.put("page", search.getPage()) ;
		map.put("rows", search.getRows()) ;
		
		gridView.setRows(sysUserDao.getUsers(map)) ;
		gridView.setRecords(sysUserDao.getUserTotal(map));
		gridView.setMaxResults(search.getRows());
		
		return gridView;
	}
	
	
}
