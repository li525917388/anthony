package com.ldh.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
    public PasswordEncoder passwordEncoder() {
        // 密码加密方式
        return new BCryptPasswordEncoder();
    }

	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()//开启登录配置
			.antMatchers("/hello").hasRole("admin")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			//.loginPage("/login")
			.loginProcessingUrl("/doLogin");
	}
	
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/demo/getPassword");
    }
	
}
