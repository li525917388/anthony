package com.ldh.eurkClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Li Dehuan
 * @title: EurekaClientApplication
 * @description: TODO
 * @date 2019-10-31 18:27
 */
@SpringBootApplication
@EnableEurekaClient

//断路器监控
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class EurekaClientApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
