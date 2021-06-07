package com.fan.demoproject.controller;

import com.fan.demoproject.config.WXConfig;
import com.fan.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
}
