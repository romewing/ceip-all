package com.ghca.ceip.job.jobdetail;

import com.ghca.ceip.job.service.SpiderHystrixService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/18.
 */
@Component
public class SpiderJob implements Job {

    @Autowired
    private SpiderHystrixService spiderService;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        spiderService.start("sccin");
    }
    @Scheduled(fixedDelay = 2*60*1000)
    public void execute() {
        spiderService.start("sccin");
    }
}
