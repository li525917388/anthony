package com.emis.sys.entity;

/**
 * 用户实体
 * @author Anthony
 *
 */
public class SysUser extends DefultEntity {

	/**
	 * 用户名
	 */
	private String userName ;
	
	
	/**
	 * 密码
	 */
	private String pwd ;
	/**
	 * 性别
	 */
	private int sex ;
	public enum sexEnum {
		Boy(1,"男"),
		Girl(2,"女") ;
		
		private String sexName ;
		private int sexCode ;
		
		private sexEnum(int code, String name) {
			this.sexCode = code ;
			this.sexName = name ;
		}

		public String getSexName() {
			return sexName;
		}

		public void setSexName(String sexName) {
			this.sexName = sexName;
		}

		public int getSexCode() {
			return sexCode;
		}

		public void setSexCode(int sexCode) {
			this.sexCode = sexCode;
		}

	}
	
	/**
	 * 姓名
	 */
	private String name ;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
