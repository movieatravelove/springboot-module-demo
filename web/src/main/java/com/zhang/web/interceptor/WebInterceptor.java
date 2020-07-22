package com.zhang.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

@Component
public class WebInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("进入controller前拦截判断浏览器类型...");
//        if("weixin".equals(getBrowserType(request))){
//        	return true;
//        }else{	
//        	JSONObject root = new JSONObject();
//    		root.put("errorcode", 500);
//    		root.put("message", "请在微信客户端内打开链接");
//    		request.setAttribute("data", root);
//			request.getRequestDispatcher("/error.html").forward(request,response);
//        	return false;
//        }  
		return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("请求处理之后进行调用");
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("整个请求结束之后被调用");
    }

    public String getBrowserType(HttpServletRequest request) { 
  	    String userAgent = request.getHeader("user-agent");   	  
  	    if (userAgent != null && userAgent.contains("MicroMessenger")) { 
  	        return "weixin"; 
  	    }else{ 
  	        return "other"; 
  	    } 
    }
}
