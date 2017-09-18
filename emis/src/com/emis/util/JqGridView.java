package com.emis.util;

import java.util.List;

public class JqGridView<T> {

	private String sord ;
	
	private String sidx ;
	
	private String nd ;
	
	private int maxResults ;
	
	private List<T> rows ;
	
	private int records ;
	
	private int total ;

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;

		if(this.maxResults != 0){
			
			this.total = records % this.maxResults == 0 ? records / this.maxResults : records / this.maxResults + 1 ;
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
