package com.zhang.mongodb;

import com.zhang.mongodb.dao.UserDao;
import com.zhang.mongodb.dao.UserDao2;
import com.zhang.mongodb.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Id;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDao2 userDao2;

    @Test
    public void saveUser() {
        User user = new User();
        user.setId(2);
        user.setName("jack");
        user.setSex("男");
        user.setPhone("18829246272");
        userDao.saveUser(user);
    }


    @Test
    public void deleteUserById() {
        userDao.deleteUserById(1L);
    }

    @Test
    public void findAll() {
        List<User> userList = userDao2.findAll();
        System.out.println(userList);
    }

    @Test
    public void save() {
        User user = new User();
        user.setId(1);
        user.setName("alex");
        user.setSex("男");
        user.setPhone("18829246272");
        user.setPassword("123123");
        userDao2.save(user);
    }

}
