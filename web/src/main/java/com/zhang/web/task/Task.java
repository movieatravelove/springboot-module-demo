package com.zhang.web.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时服务
 */
@Component
public class Task {

    @Scheduled(cron="0 0/59 * * * ?")
    private void process(){

    }

}
