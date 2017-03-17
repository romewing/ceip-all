package com.ghca.ceip.spider;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by gh on 2017/3/15.
 */
public class SCCINSpider extends Spider {

    private PageProcessor pageProcessor;

    public SCCINSpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }
}
