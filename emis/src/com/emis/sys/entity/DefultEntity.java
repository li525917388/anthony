package com.emis.sys.entity;

import java.util.Date;

public class DefultEntity {
	
	
	/**
	 * 主键
	 */
	private int id ;
	

	/**
	 * 删除标志
	 */
	private int dr ;
	
	
	/**
	 * 创建时间
	 */
	private Date createdTime ;
	
	
	/**
	 * 最后更新时间
	 */
	private Date updateTime ;
	
	
	/**
	 * 排序
	 */
	private int order ;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDr() {
		return dr;
	}


	public void setDr(int dr) {
		this.dr = dr;
	}


	public Date getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}
	
	
}
