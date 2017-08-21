package com.emis.sys.entity;

/**
 * 角色菜单表
 * @author Administrator
 *
 */
public class SysRoleMenu extends DefultEntity{

	/**
	 * 角色id
	 */
	private int rid ;
	
	
	/**
	 * 菜单id
	 */
	private int mid ;


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public int getMid() {
		return mid;
	}


	public void setMid(int mid) {
		this.mid = mid;
	}
	
	
}
