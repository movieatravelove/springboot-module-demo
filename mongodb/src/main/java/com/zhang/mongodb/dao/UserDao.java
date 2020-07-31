package com.zhang.mongodb.dao;

import com.zhang.mongodb.entity.User;

/**
 * @Author: zhang
 * @Date: 2020/7/31 12:44
 * @Description:
 * @Version: 1.0
 */
public interface UserDao {


    void saveUser(User user);

    User findUserByUserName(String userName);

    void updateUser(User user);

    void deleteUserById(Long id);

}
