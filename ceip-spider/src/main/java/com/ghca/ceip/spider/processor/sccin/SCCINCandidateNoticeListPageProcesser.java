package com.ghca.ceip.spider.processor.sccin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.handler.RequestMatcher;
import us.codecraft.webmagic.handler.SubPageProcessor;
import us.codecraft.webmagic.selector.HtmlNode;
import us.codecraft.webmagic.selector.Selectable;

import javax.annotation.Resource;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Created by gh on 2017/3/16.
 */
@Component
public class SCCINCandidateNoticeListPageProcesser implements SubPageProcessor {

    public static final String URL = "http://www.sccin.com.cn/InvestmentInfo/ZhaoBiao/houxuanren.aspx";
    private static final String[] DATE_PATTERNS = {"yyyy-MM-dd"};

    private static final Logger LOG = LoggerFactory.getLogger(SCCINCandidateNoticeListPageProcesser.class);


    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Override
    public MatchOther processPage(Page page) {
        page.setNeedCycleRetry(true);
        List<Selectable> nodes = page.getHtml().$("table.lie table tr").nodes();
        JSONArray candidateNotices = new JSONArray(nodes.size());
        for (Selectable node : nodes) {
            JSONObject candidateNotice = new JSONObject();
            List<Selectable> tdNodes = node.$("td").nodes();
            //candidateNotice.setProject(tdNodes.get(0).xpath("//a/@title/text()").toString());

            String url = tdNodes.get(0).xpath("//a/@href").toString();
            Boolean member = stringRedisTemplate.opsForSet().isMember("set_www.sccin.com.cn", url);
            if(member) {
                LOG.info("{}已经采集过",url);
                //continue;
            }
            candidateNotice.put("project", tdNodes.get(0).xpath("//a/@title").toString());
            candidateNotice.put("url", url);
            candidateNotice.put("region", tdNodes.get(1).xpath("//td/text()").toString().trim());
            candidateNotice.put("date", tdNodes.get(2).xpath("//td/text()").toString().trim());
            candidateNotice.put("source", "四川建设网");
            if(StringUtils.isNotBlank(url)) {
                page.addTargetRequest(url);
                //candidateNotice.setNumber(url.substring(url.lastIndexOf("=")));
                //candidateNotice.put("number", url.substring(url.lastIndexOf("=")+1));
            }

            /*try {
                candidateNotice.setDate(DateUtils.parseDate(tdNodes.get(2).xpath("//td/text()").toString().trim(),DATE_PATTERNS));
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            candidateNotices.add(candidateNotice);
        }
        page.putField("candidateNotices", candidateNotices);

        return MatchOther.NO;
    }

    @Override
    public boolean match(Request page) {
        return URL.equals(page.getUrl());
    }
}
