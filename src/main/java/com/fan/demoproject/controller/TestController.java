package com.fan.demoproject.controller;

import com.fan.demoproject.config.WXConfig;
import com.fan.demoproject.task.AsyncTask;
import com.fan.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {

    @Value("${wxpay.appid}")
    private String wxPayAppid;

    @Value("${wxpay.secret}")
    private String paySecret;

    @Autowired
    private WXConfig wxConfig;

    @Autowired
    private AsyncTask asyncTask;


    @GetMapping("list")
    public JsonData textExt(){
        int i = 1/0;

        return JsonData.buildSuccess("");
    }

    @GetMapping("get_config")
    public JsonData testConfig(){
        Map<String, String> map = new HashMap<>();
//        map.put("appid", wxPayAppid);
//        map.put("secret", paySecret);
//
//        return JsonData.buildSuccess(map);
        map.put("appid", wxConfig.getPayAppid());
        map.put("secret", wxConfig.getPaySecret());
        map.put("mechid", wxConfig.getPayMechId());

        return JsonData.buildSuccess(map);
    }

    @GetMapping("async")
    public JsonData testAsync(){

        long begin = System.currentTimeMillis();
//        asyncTask.task1();
//        asyncTask.task2();
//        asyncTask.task3();
        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();

        for (;;){
          if (task4.isDone() && task5.isDone()){
              try {
                  String task4Result = task4.get();
                  System.out.println(task4Result);
                  String task5Result = task5.get();
                  System.out.println(task5Result);

              } catch (InterruptedException e) {
                  e.printStackTrace();
              } catch (ExecutionException e) {
                  e.printStackTrace();
              }finally {
                  break;
              }
          }
        }

        long end = System.currentTimeMillis();

        return JsonData.buildSuccess(end - begin);

    }
}
