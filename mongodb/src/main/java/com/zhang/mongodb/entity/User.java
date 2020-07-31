package com.zhang.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: zhang
 * @Date: 2020/7/31 12:42
 * @Description:
 * @Version: 1.0
 */
@Data
@Document(collection = "user")
public class User {

    @Id //主键字段
    private long id;
    private String name;
    private String sex;
    private String phone;
    @Transient //为非表字段
    private String password;

}
