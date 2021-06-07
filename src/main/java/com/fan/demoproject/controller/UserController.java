package com.fan.demoproject.controller;


import com.fan.demoproject.domain.User;
import com.fan.demoproject.service.UserService;
import com.fan.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {

//    Sample1
//    @PostMapping("login")
//    public JsonData login(String pwd, String username){
//
//        System.out.println("username = " + username + " pwd=" + pwd);
//
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    public UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user){
        System.out.println("user= " +user.toString());

        String token = userService.login(user.getUsername(), user.getPwd());

        return token != null ? JsonData.buildSuccess(token) : JsonData.buildError("账号密码错误");
    }

    @GetMapping("list")
    public JsonData listUser(){
        return JsonData.buildSuccess(userService.listUser());
    }
}
