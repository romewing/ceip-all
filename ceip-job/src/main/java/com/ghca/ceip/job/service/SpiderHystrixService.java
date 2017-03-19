package com.ghca.ceip.job.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/18.
 */

@Service
public class SpiderHystrixService {

    private static final Logger  LOG = LoggerFactory.getLogger(SpiderHystrixService.class);

    @Autowired
    private SpiderService spiderService;


    @HystrixCommand(fallbackMethod = "fallback")
    public int start(String type) {
        return spiderService.start(type);
    }

    public int fallback(String type) {
        LOG.warn("调用失败");
        return 0;
    }
}
