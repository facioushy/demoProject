package com.fan.demoproject.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * 定时统计订单，金额
 */

@Component
public class VideoOrderTask {

    //每两秒进行一次
    //@Scheduled(fixedRate =  2000)
    //@Scheduled(cron = "*/1 * * * * *")
    public void sum(){

        //正常的时候是从数据库中查询
        System.out.println(LocalDateTime.now() + "当前交易额= " + Math.random());

    }

}
