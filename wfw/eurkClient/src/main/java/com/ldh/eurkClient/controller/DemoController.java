package com.ldh.eurkClient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li Dehuan
 * @title: DemoController
 * @description: TODO
 * @date 2019-10-31 18:31
 */
@RestController
public class DemoController {

    @Value("${server.port}")
    String port;

    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }


    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
