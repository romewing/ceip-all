package com.ghca.ceip.spider.controller;

import com.ghca.ceip.spider.SpiderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

/**
 * Created by gh on 2017/3/17.
 */

@RestController
public class SpiderController {

    @Autowired
    private SpiderFactory spiderFactory;


    @PutMapping(value = "/spider/{type}")
    public int spider(@PathVariable("type") String type){
        return spiderFactory.getSpider(type);
    }
}
