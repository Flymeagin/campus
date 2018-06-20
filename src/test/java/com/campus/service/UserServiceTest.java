package com.campus.service;

import com.campus.BaseTest;
import com.campus.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;

    @Test
    public  void userLogin(){
        User user = new User();
        user.setUserId("hahah");
        user.setNickName("小小文");
        user.setRealName("刘楷文");
        user.setGender("男");
        user.setTxUrl("hello");
        user.setDescription("yigeren");
        System.out.println(userService.userLogin(user).getUser().getUserId());
    }
    @Test
    public void queryUser(){
        System.out.println(userService.queryUser().getUserList().size());
    }

}