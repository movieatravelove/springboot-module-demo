package com.zhang.api.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时服务
 */
@Component
public class Task {

    /**
     * 五秒执行一次
     */
    @Scheduled(cron="0/5 * * * * ?")
    private void process(){
//        System.out.println("哈哈哈哈");
    }


}
