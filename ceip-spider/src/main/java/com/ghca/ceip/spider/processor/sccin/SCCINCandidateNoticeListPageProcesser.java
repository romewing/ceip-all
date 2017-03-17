package com.ghca.ceip.spider.processor.sccin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.handler.RequestMatcher;
import us.codecraft.webmagic.handler.SubPageProcessor;
import us.codecraft.webmagic.selector.HtmlNode;
import us.codecraft.webmagic.selector.Selectable;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Created by gh on 2017/3/16.
 */
@Component
public class SCCINCandidateNoticeListPageProcesser implements SubPageProcessor {

    public static final String URL = "http://www.sccin.com.cn/InvestmentInfo/ZhaoBiao/houxuanren.aspx";
    private static final String[] DATE_PATTERNS = {"yyyy-MM-dd"};



    @Override
    public MatchOther processPage(Page page) {
        page.setNeedCycleRetry(true);
        List<Selectable> nodes = page.getHtml().$("table.lie table tr").nodes();
        JSONArray candidateNotices = new JSONArray(nodes.size());
        for (Selectable node : nodes) {
            JSONObject candidateNotice = new JSONObject();
            List<Selectable> tdNodes = node.$("td").nodes();
            //candidateNotice.setProject(tdNodes.get(0).xpath("//a/@title/text()").toString());
            candidateNotice.put("project", tdNodes.get(0).xpath("//a/@title/text()").toString());
            String url = tdNodes.get(0).xpath("//a/@href").toString();
            candidateNotice.put("url", tdNodes.get(0).xpath("//a/@href").toString());
            candidateNotice.put("region", tdNodes.get(1).xpath("//td/text()").toString().trim());
            candidateNotice.put("date", tdNodes.get(2).xpath("//td/text()").toString().trim());
            if(StringUtils.isNotBlank(url)) {
                page.addTargetRequest(url);
                //candidateNotice.setNumber(url.substring(url.lastIndexOf("=")));
                candidateNotice.put("number", url.substring(url.lastIndexOf("=")));
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
