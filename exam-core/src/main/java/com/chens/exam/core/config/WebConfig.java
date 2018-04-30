package com.chens.exam.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 网站参数
 *
 * @author songchunlei@qq.com
 * @create 2018/4/29
 */
@ConfigurationProperties(prefix = "chens-exam")
@Component
public class WebConfig {
    private String wmsurl;
    private String bookurl;

    public String getWmsurl() {
        return wmsurl;
    }

    public void setWmsurl(String wmsurl) {
        this.wmsurl = wmsurl;
    }

    public String getBookurl() {
        return bookurl;
    }

    public void setBookurl(String bookurl) {
        this.bookurl = bookurl;
    }
}
