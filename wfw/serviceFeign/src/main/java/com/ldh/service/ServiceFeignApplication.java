package com.ldh.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Li Dehuan
 * @title: ServiceFeignApplication
 * @description: TODO
 * @date 2019-11-01 9:20
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceFeignApplication {

    public static void main(String[] args){

        SpringApplication.run(ServiceFeignApplication.class, args);
        System.out.println("feign 启动成功...");

    }
}
