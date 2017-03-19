package com.ghca.ceip.spider.pipeline;

import com.alibaba.fastjson.JSONArray;
import com.ghca.ceip.spider.service.CoreHystrixService;
import com.ghca.ceip.spider.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.handler.RequestMatcher;
import us.codecraft.webmagic.handler.SubPipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by gh on 2017/3/16.
 */

@Component
public class CandidateNoticePipeline implements SubPipeline {

    @Autowired
    private CoreHystrixService coreService;


    @Override
    public MatchOther processResult(ResultItems resultItems, Task task) {
        JSONArray candidateNotices = resultItems.get("candidateNotices");
        if(candidateNotices!=null) {
            coreService.saveCandidateNotice(candidateNotices);
        }
        return MatchOther.NO;
    }

    @Override
    public boolean match(Request page) {
        return page.getUrl().equals("http://www.sccin.com.cn/InvestmentInfo/ZhaoBiao/houxuanren.aspx");
    }
}
