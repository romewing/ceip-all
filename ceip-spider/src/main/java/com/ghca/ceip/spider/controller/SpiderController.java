package com.ghca.ceip.spider.controller;

import com.ghca.ceip.spider.SpiderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

/**
 * Created by gh on 2017/3/17.
 */

@RestController
public class SpiderController {

    @Autowired
    private SpiderFactory spiderFactory;


    @GetMapping(value = "spider")
    public String spider(String type){
        Spider spider = spiderFactory.getSpider(type);
        return spider.getUUID();
    }
}
