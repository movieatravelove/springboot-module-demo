package com.zhang.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private WebInterceptor webInterceptor;
	
	//需要拦截的路径
    String[] addPathPatterns={
            "/quest/**",
            "/pages/**"
    };
    //不拦截的路径
    String[] excludePathPatterns={
           "/sys/**",
           "/static/**",
           "/index"
    };


   @Override
   public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webInterceptor)              
                .excludePathPatterns(excludePathPatterns)
                .addPathPatterns(addPathPatterns);       
    }
}
