package com.zhang.web.modules.sys.controller;

import com.zhang.web.modules.sys.entity.SysUser;
import com.zhang.web.modules.sys.service.SysUserService;
import com.zhang.web.config.shiro.ShiroUtils;
import com.zhang.web.utils.IPUtils;
import com.zhang.web.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "登录")
@Controller
@ApiIgnore
public class SysLoginController extends AbstractController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    HttpServletRequest request;


    @ApiOperation("用户登录")
    @ResponseBody
    @PostMapping("/login")
    public R login(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error("账号或密码不正确");
        } catch (LockedAccountException e) {
            return R.error("账号已被锁定,请联系管理员");
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }
        SysUser sysUser = ShiroUtils.getUserEntity();
        sysUser.setLastLoginIp(IPUtils.getIpAddr(request));
        sysUserService.loginUser(sysUser);
        return R.ok().put("user",sysUser);
    }



    /**
     * 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public R logout() {
        ShiroUtils.logout();
        return R.ok();
    }



}
