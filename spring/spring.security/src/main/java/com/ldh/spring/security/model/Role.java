package com.ldh.spring.security.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author Li Dehuan
 * @date 2020年2月29日
 *
 */
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
