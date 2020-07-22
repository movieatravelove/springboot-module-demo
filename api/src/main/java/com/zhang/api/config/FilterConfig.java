package com.zhang.api.config;

import com.zhang.api.filter.PlatformIdVerifyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/** 
  * @Author: zhang 
  * @Date: 2020-07-21 18:03:54 
  * @Description: 过滤器配置
  * @Version: 1.0
  */  
@Configuration
@Component
public class FilterConfig {

    @Autowired
    private PlatformIdVerifyFilter filter;

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        List<String> urlPatterns = new ArrayList<>();
        // 设置匹配的url
        urlPatterns.add("/api/book/getBookInfos");
        urlPatterns.add("/api/book/getBookPages");
        urlPatterns.add("/api/book/getBookInfoAndPages");

        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
