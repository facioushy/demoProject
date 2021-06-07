package com.fan.demoproject;

import com.fan.demoproject.controller.UserController;
import com.fan.demoproject.domain.User;
import com.fan.demoproject.utils.JsonData;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoProjectApplication.class})
public class UserTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest(){

        User user = new User();
        user.setUsername("jack");
        user.setPwd("123");
        JsonData jsonData = userController.login(user);

        System.out.println(jsonData.toString());

        TestCase.assertEquals(0, jsonData.getCode());
    }

}
