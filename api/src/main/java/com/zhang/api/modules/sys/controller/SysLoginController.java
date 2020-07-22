package com.zhang.api.modules.sys.controller;
import com.zhang.api.modules.sys.service.SysUserService;
import com.zhang.api.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "登录")
@Controller
public class SysLoginController extends AbstractController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    HttpServletRequest request;

    @ApiOperation("用户登录")
    @ResponseBody
    @PostMapping("/login")
    public R login(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {

        return R.ok("登录成功");
    }
    /**
     * 没有登录返回
     */
    @RequestMapping(value = "unLogin", method = RequestMethod.GET)
    @ResponseBody
    public R unLogin() {
        return R.error("没有登录");
    }


    /**
     * 页面跳转
     */
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String module() {
        return "login";
    }

}
