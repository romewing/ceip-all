package com.ghca.ceip.spider.processor.sccin;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.handler.SubPageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by gh on 2017/3/16.
 */
@Component
public class SCCINCandidateNoticeDetailPageProcesser implements SubPageProcessor {

    public static final String URL1 = "http://www.sccin.com.cn/InvestmentInfo/ZhaoBiao/HXRDetail_c.aspx\\?id=.*";
    public static final String URL2 = "http://www.sccin.com.cn/InvestmentInfo/ZhaoBiao/HXRDetail.aspx\\?id=.*";
    private static final Pattern PATTERN1 = Pattern.compile(URL1);
    private static final Pattern PATTERN2 = Pattern.compile(URL2);



    @Override
    public MatchOther processPage(Page page) {
        page.getUrl();
        Html html = page.getHtml();
        return MatchOther.NO;
    }

    @Override
    public boolean match(Request page) {
        String url = page.getUrl();
        return PATTERN1.matcher(url).matches() || PATTERN2.matcher(url).matches();
    }
}
