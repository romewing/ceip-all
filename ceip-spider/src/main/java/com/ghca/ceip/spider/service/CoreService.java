package com.ghca.ceip.spider.service;

import com.alibaba.fastjson.JSONArray;
import com.ghca.ceip.spider.model.CandidateNotice;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gh on 2017/3/16.
 */

public interface CoreService {

    @RequestMapping(value = "/candidatenotice", method = RequestMethod.PUT)
    public void saveCandidateNotice(@RequestBody JSONArray candidateNotices);

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestBody String value);
}
