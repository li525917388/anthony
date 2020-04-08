package com.ldh.spring.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@MapperScan(value={"com.ldh.spring.security.dao"})
@SpringBootApplication
public class App {
	
    public static void main( String[] args ) {
    	
        SpringApplication.run(App.class, args);
    }
}
