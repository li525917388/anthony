package com.ldh.service.demo;/**
 * @title: SchedualServiceHi
 * @description: TODO
 * @author Li Dehuan
 * @date 2019-11-01 9:23
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Li Dehuan
 * @title: SchedualServiceHi
 * @Description: TODO
 * @date 2019-11-01 9:23
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
