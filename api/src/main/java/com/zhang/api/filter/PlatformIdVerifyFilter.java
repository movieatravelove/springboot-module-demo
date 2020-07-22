package com.zhang.api.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * @Author: zhang
 * @Date: 2019/2/13 18:46
 * @Description:
 */

@Slf4j
@Component
@WebFilter
public class PlatformIdVerifyFilter implements Filter {

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {    
            chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }


}
