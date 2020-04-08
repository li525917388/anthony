package com.ldh.spring.security.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ldh.spring.security.dao.UserDao;
import com.ldh.spring.security.model.Role;
import com.ldh.spring.security.model.User;

@Service
public class UserService implements UserDetailsService {

	@Resource
	UserDao userDao;
	
	@Resource
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		User user = userDao.loadUserByUsername(userName);
		
		if (null != user) {
			List<Role> roles = userDao.getRolesByUserId(user.getId());
			user.setAuthorities(roles);
		}
		
		return user;
	}

	
	
	

}
