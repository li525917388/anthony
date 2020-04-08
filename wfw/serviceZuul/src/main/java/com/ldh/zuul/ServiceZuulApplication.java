package com.ldh.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Li Dehuan
 * @title: ServiceZuulApplication
 * @description: TODO
 * @date 2019-11-01 15:22
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZuulApplication {

    public static void main(String[] args){

        SpringApplication.run(ServiceZuulApplication.class, args);
        System.out.println("zuul 启动成功...");
    }

}
