package com.zhang.web.modules.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SysPageController extends AbstractController{
    @Autowired
    HttpServletRequest request;
    /**
     * 页面跳转
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/error.html", method = RequestMethod.GET)
    public String error() {
        return "error";
    }
}
