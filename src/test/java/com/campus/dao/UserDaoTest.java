package com.campus.dao;

import com.campus.BaseTest;
import com.campus.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void login() {

        User user = new User();
        user.setUserId("kevin");
        user.setNickName("小小文");
        user.setRealName("刘楷文");
        user.setGender("男");
        user.setTxUrl("hello");
        user.setDescription("yigeren");
        user.setFlag(0);
        user.setCreateTime(new Date());
        user.setLastEditTime(new Date());
        System.out.println(userDao.login(user));
    }

    @Test
    public void exist() {
        User user = new User();
        user.setUserId("o9NU95btTFCKFhkZY_4ETnjjrWfM");
        System.out.println(userDao.exist(user).getSigns().size());
    }
}