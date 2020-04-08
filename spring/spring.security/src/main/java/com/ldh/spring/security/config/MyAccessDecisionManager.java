package com.ldh.spring.security.config;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager {

	private final static Logger logger = LoggerFactory.getLogger(MyAccessDecisionManager.class);
	
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		
		 if (null == configAttributes || 0 >= configAttributes.size()) {
	            return;
	        } else {
	            String needRole;
	            for(Iterator<ConfigAttribute> iter = configAttributes.iterator(); iter.hasNext(); ) {
	                needRole = iter.next().getAttribute();

	                for(GrantedAuthority ga : authentication.getAuthorities()) {
	                    if(needRole.trim().equals(ga.getAuthority().trim())) {
	                        return;
	                    }
	                }
	            }
	            
	            logger.info("当前访问没有权限");
	            throw new AccessDeniedException("当前访问没有权限");
	        }
		
	}

	 /**
     * 表示此AccessDecisionManager是否能够处理传递的ConfigAttribute呈现的授权请求
     */
	@Override
	public boolean supports(ConfigAttribute arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
     * 表示当前AccessDecisionManager实现是否能够为指定的安全对象（方法调用或Web请求）提供访问控制决策
     */
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
