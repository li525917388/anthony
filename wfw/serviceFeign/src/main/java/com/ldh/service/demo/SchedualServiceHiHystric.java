package com.ldh.service.demo;

import org.springframework.stereotype.Component;

/**
 * @author Li Dehuan
 * @title: SchedualServiceHiHystric
 * @description: TODO
 * @date 2019-11-01 10:00
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name + ", I will fix this feature as soon as possible.";
    }
}
