package com.ldh.spring.security.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;
    
	private List<Role> authorities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
    public String getUsername() {
        return username;
    }
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
    public String getPassword() {
        return password;
    }

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public List<Role> getAuthorities() {
        return authorities;
    }

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}


	/**
     * 用户账号是否过期
     */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
     * 用户账号是否被锁定
     */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
     * 用户密码是否过期
     */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
     * 用户是否可用
     */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
