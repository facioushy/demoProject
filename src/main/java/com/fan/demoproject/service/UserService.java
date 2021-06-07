package com.fan.demoproject.service;

import com.fan.demoproject.domain.User;

import java.util.List;

public interface UserService {

    String login(String username, String pwd);
    List<User> listUser();
}
