package com.ldh.spring.security.dao;

import java.util.List;

import com.ldh.spring.security.model.Role;
import com.ldh.spring.security.model.User;

public interface UserDao {

	/**
	 * 
	 * @param userName
	 * @return
	 */
	User loadUserByUsername(String userName);
	
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	List<Role> getRolesByUserId(Long userId);
}
