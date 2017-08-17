package com.emis.sys.entity;

/**
 * 角色实体
 * @author Administrator
 *
 */
public class SysRole extends DefultEntity {

	/**
	 * 角色名称
	 */
	private String rname ;
	
	/**
	 * 角色编码
	 */
	private String rcode ;

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	
	
	
}
