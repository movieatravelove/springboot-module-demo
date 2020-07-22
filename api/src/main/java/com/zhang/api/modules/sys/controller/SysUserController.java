package com.zhang.api.modules.sys.controller;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhang.api.modules.sys.entity.SysUser;
import com.zhang.api.modules.sys.service.SysUserService;
import com.zhang.api.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户
 */
@Api(tags="用户")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController{
    @Autowired
    private SysUserService sysUserService;
    /**
     * 用户信息
     */
    @ApiOperation("获取指定用户信息")
    @GetMapping("/info")
    @ResponseBody
    public R info(@RequestParam(required = true) String username){
       SysUser sysUser= sysUserService.loadUserByUsername(username);
        return R.ok().put("user", sysUser);
    }


    @ApiOperation("获取用户列表，分页")
    @GetMapping("/listUsersPage")
    @ResponseBody
    public R listUsersPage(@RequestParam("currentPage") Integer currentPage,
                           @RequestParam("pageSize") Integer pageSize){
        Page page=sysUserService.listUsersPage(currentPage,pageSize);
        R r=R.ok();
        r.put("page",page);
        return r;
    }



}
