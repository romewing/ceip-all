package com.ghca.ceip.spider.processor.sccin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.handler.SubPageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by gh on 2017/3/16.
 */
@Component
public class SCCINCandidateNoticeDetailPageProcesser implements SubPageProcessor {

    public static final String URL = "http://www.sccin.com.cn/InvestmentInfo/ZhaoBiao/HXRDetail(_c)?.aspx\\?id=.*";
    private static final Pattern PATTERN = Pattern.compile(URL);


    private static Map<Integer, String> CandicateIndex = new HashMap<>();




    @Override
    public MatchOther processPage(Page page) {

        Html html = page.getHtml();
        Selectable xpath = html.xpath("//div[@class='kuang']//tidyText()");
        System.out.println(xpath.toString());
        /*
        JSONObject candidateNotice = new JSONObject();
        candidateNotice.put("url", page.getUrl());
        candidateNotice.put("source", "四川建设网");
        String region = html.xpath("span[@id='ContentPlaceHolder1_lbAreaName']/text()").toString();
        candidateNotice.put("region", region);
        String date = html.xpath("span[@id='ContentPlaceHolder1_lbPublisTime']/text()").toString();
        candidateNotice.put("date", date);
        String project = html.xpath("span[@id='ContentPlaceHolder1_lbProjName']/text()").toString();
        candidateNotice.put("project", project);
        String owner = html.xpath("span[@id='ContentPlaceHolder1_lbOwnerName']/text()").toString();
        candidateNotice.put("owner", owner);
        List<Selectable> candidatesTable = html.xpath("//div[@class=kuang]/table[@class=hxr_table]").nodes().get(2).xpath("//tr").nodes();
        JSONArray candidates = new JSONArray();
        for (int i = 2; i < candidatesTable.size(); i++) {
            List<Selectable> nodes = candidatesTable.get(i).xpath("//td").nodes();
            JSONObject candidate = new JSONObject();
            candidate.put("rank", nodes.get(1).xpath("/text()".toString().trim()));
            candidate.put("name", nodes.get(2).xpath("/text()").toString().trim());
            candidate.put("bidPrice", nodes.get(3).xpath("/text()").toString().trim());
            candidate.put("reviewPrice", nodes.get(4).xpath("/text()").toString().trim());
            candidate.put("score", nodes.get(5).xpath("/text()").toString().trim());
            JSONArray leaders = new JSONArray();
            JSONObject leader = new JSONObject();
            leader.put("name", nodes.get(7).xpath("/text()".toString().trim()));
            leader.put("title", nodes.get(8).xpath("/text()".toString().trim()));
            leader.put("number", nodes.get(9).xpath("/text()".toString().trim()));
            leaders.add(leader);
            candidate.put("leanders", leaders);


        }

        System.out.println(candidateNotice.toJSONString());
        System.out.println(html);*/
        return MatchOther.NO;
    }

    @Override
    public boolean match(Request page) {
        String url = page.getUrl();
        return PATTERN.matcher(url).matches();
    }
}
