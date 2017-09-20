package com.emis.contract.entity;

import com.emis.sys.entity.DefultEntity;

/**
 * 项目
 * @author Anthony
 *
 */
public class Project extends DefultEntity {

	/**
	 * 项目名称
	 */
	private String projectName ;
	
	
	/**
	 * 项目编码
	 */
	private String projectNo ;


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectNo() {
		return projectNo;
	}


	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	
	
}
