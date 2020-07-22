package com.zhang.web.modules.sys.controller;

import com.zhang.web.common.annotation.SysLog;
import com.zhang.web.modules.sys.entity.SysUser;
import com.zhang.web.modules.sys.service.SysUserService;
import com.zhang.web.config.shiro.ShiroUtils;
import com.zhang.web.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 系统用户
 */
@Api(tags="用户")
@RestController
@RequestMapping("/sys/user")
@ApiIgnore
public class SysUserController extends AbstractController{
    @Autowired
    private SysUserService sysUserService;
    /**
     * 用户信息
     */
    @SysLog("获取指定用户信息")
    @ApiOperation("获取指定用户信息")
    @GetMapping("/info")
    @ResponseBody
//    @RequiresRoles("sysmanager")  //需要sysmanager权限
//    @RequiresPermissions(logical = Logical.OR,value={"user:view"}) //需要user:view权限
    public R info(@RequestParam(required = true) String username){
        SysUser admin= ShiroUtils.getUserEntity();
       SysUser sysUser= sysUserService.loadUserByUsername(username);
        return R.ok().put("user", sysUser).put("admin",admin);
    }




}
