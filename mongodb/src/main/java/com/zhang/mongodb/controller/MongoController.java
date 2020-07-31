package com.zhang.mongodb.controller;


import com.zhang.mongodb.dao.UserDao;
import com.zhang.mongodb.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhang
 * @Date: 2020/7/22 14:57
 * @Description:
 * @Version: 1.0
 */
@Api("MongoDB 测试")
@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/save")
    @ResponseBody
    public void info(){
        User user = new User();
        user.setId(1);
        user.setName("alex");
        user.setSex("男");
        user.setPhone("18829246272");
        userDao.saveUser(user);
    }

}
