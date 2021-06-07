package com.fan.demoproject.mapper;

import com.fan.demoproject.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("jack", new User(1, "jack", "123"));
        userMap.put("jack2", new User(2, "jack2", "1234"));
        userMap.put("jack3", new User(3, "jack3", "12345"));
    }

    public User login(String username, String pwd){
        User user = userMap.get(username);
        if (user == null) return null;

        if (user.getPwd().equals(pwd)){
            return user;
        }
        return null;
    }

    public List<User> listUser(){
        List<User> list = new ArrayList<>();
        list.addAll(userMap.values());
        return list;
    }
}
