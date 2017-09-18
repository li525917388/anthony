package com.emis.util;

import java.util.ArrayList;
import java.util.List;

public class Search {

	/**
	 * 当前页数
	 */
	private int page ;
	
	/**
	 * 每页数据数
	 */
	private int rows ;
	
	
	/**
	 * 条件查询值列表
	 */
	private List<Filter> filters ;
	
	
	/**
	 * 排序列表
	 */
	private List<Sort> sorts ;
	
	public Search(){
		filters = new ArrayList<Filter>() ;
	}
	
	
	/**
	 * 添加等值查询
	 */
	public void addFilterEqual(String cloum, Object value) {
		filters.add(new Filter(cloum,value,"=")) ;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public List<Sort> getSorts() {
		return sorts;
	}

	public void setSorts(List<Sort> sorts) {
		this.sorts = sorts;
	}
	
	
}
