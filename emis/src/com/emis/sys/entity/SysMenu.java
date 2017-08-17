package com.emis.sys.entity;

import java.util.List;

/**
 * 菜单实体
 * @author Administrator
 *
 */
public class SysMenu extends DefultEntity {

	
	
	/**
	 * 菜单名称
	 */
	private String mname ;
	
	
	/**
	 * 菜单编码
	 */
	private String mcode ;
	
	
	/**
	 * 父菜单id
	 */
	private int pid ;
	
	
	/**
	 * 菜单url
	 */
	private String url ;
	
	
	/**
	 * 菜单图标
	 */
	private String icon ;
	
	
	/**
	 * 子菜单
	 */
	private List<SysMenu> cMenus ;


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public List<SysMenu> getcMenus() {
		return cMenus;
	}


	public void setcMenus(List<SysMenu> cMenus) {
		this.cMenus = cMenus;
	}


	public String getMcode() {
		return mcode;
	}


	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	
	
}
