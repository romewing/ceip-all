package com.ghca.ceip.spider.service;

import com.alibaba.fastjson.JSONArray;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gh on 2017/3/16.
 */

@Service
public class CoreHystrixService {

    @Autowired
    private CoreService coreService;

    public void saveCandidateNotice(JSONArray candidateNotices) {
        coreService.saveCandidateNotice(candidateNotices);
    }

    @HystrixCommand(fallbackMethod = "fallbackSave")
    public void saveCandidateNotice(String candidateNotices) {
        coreService.test(candidateNotices);
    }

    public void fallbackSave(String candidateNotices) {
        System.out.println("fallbackSave");
    }

}
