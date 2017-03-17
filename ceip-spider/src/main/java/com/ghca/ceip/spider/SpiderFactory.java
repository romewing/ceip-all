package com.ghca.ceip.spider;

import com.ghca.ceip.spider.pipeline.CandidateNoticePipeline;
import com.ghca.ceip.spider.processor.sccin.SCCINCandidateNoticeDetailPageProcesser;
import com.ghca.ceip.spider.processor.sccin.SCCINCandidateNoticeListPageProcesser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.handler.CompositePageProcessor;
import us.codecraft.webmagic.handler.SubPageProcessor;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.RedisScheduler;
import us.codecraft.webmagic.scheduler.Scheduler;

import java.util.ArrayList;
import java.util.List;

import static us.codecraft.webmagic.Spider.*;

/**
 * Created by gh on 2017/3/16.
 */

@Component
public class SpiderFactory {

    private static final SpiderFactory _instance = new SpiderFactory();

    @Autowired
    private List<Pipeline> pipelines;

    @Autowired
    private SubPageProcessor[] subPageProcessors;

    @Autowired
    private Scheduler scheduler;


    public static SpiderFactory getInstance() {
        return _instance;
    }

    public Spider getSpider(String type) {
        CompositePageProcessor pageProcessor = new CompositePageProcessor(Site.me().setTimeOut(1000*60));
        pageProcessor.setSubPageProcessors(subPageProcessors);
        List<String> startUrls = new ArrayList<>();
        startUrls.add(SCCINCandidateNoticeListPageProcesser.URL);
        for(SubPageProcessor subPageProcessor : subPageProcessors) {
            String packageName = subPageProcessor.getClass().getPackage().getName();
            String name = packageName.substring(packageName.lastIndexOf(".")+1);
            if(type.equalsIgnoreCase(name)) {
                pageProcessor.addSubPageProcessor(subPageProcessor);
            }
        }
        return create(pageProcessor).setScheduler(scheduler).startUrls(startUrls).addPipeline(pipelines.get(0));
    }
}
