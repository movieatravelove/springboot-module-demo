package com.zhang.mongodb.dao;

import com.zhang.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhang
 * @Date: 2020/7/31 15:30
 * @Description: 接口继承自MongoRepository，泛型分别为实体对象和主键类型。
 * 通过继承MongoRepository，UserDao包含了一些增删改查的方法。无需要手动实现。
 * @Version: 2.0
 */
@Repository
public interface UserDao2 extends MongoRepository<User, Long> {
}
