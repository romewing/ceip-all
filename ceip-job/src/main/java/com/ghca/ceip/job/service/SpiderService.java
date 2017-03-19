package com.ghca.ceip.job.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/18.
 */

@FeignClient("spider")
public interface SpiderService {


    @RequestMapping(value = "/spider/{type}", method = RequestMethod.PUT)
    public int start(@PathVariable("type") String type);
}
