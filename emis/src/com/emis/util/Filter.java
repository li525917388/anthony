package com.emis.util;

/**
 * 查询条件工具类
 * @author Administrator
 *
 */
public class Filter {

	/**
	 * 字段名称
	 */
	private String cloum ;
	
	
	/**
	 * 匹配值
	 */
	private Object value ;
	
	
	/**
	 * 查询方式
	 */
	private Object type ;
	
	
	public Filter(){}

	public Filter(String cloum,Object value,Object type){
		
	}

	public String getCloum() {
		return cloum;
	}


	public void setCloum(String cloum) {
		this.cloum = cloum;
	}


	public Object getValue() {
		return value;
	}


	public void setValue(Object value) {
		this.value = value;
	}


	public Object getType() {
		return type;
	}


	public void setType(Object type) {
		this.type = type;
	}
	
	
}
