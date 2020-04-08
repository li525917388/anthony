package com.ldh.zipkin2;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Li Dehuan
 * @title: ZipkinApplication
 * @description: TODO
 * @date 2020-03-04 14:13
 */
@SpringBootApplication
@RestController
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ZipkinApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/hi")
    public String home(){
        LOG.log(Level.INFO, "hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info(){
        LOG.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
