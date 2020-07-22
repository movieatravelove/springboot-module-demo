package com.zhang.common.modules.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhang
 * @Date: 2020/7/22 14:57
 * @Description:
 * @Version: 1.0
 */
@Api("common 测试")
@RestController
@RequestMapping("/common")
public class CommonController {


    @GetMapping("/info")
    @ResponseBody
    public String info(String username){
        return username;
    }

}
