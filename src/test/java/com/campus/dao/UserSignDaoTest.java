package com.campus.dao;

import com.campus.BaseTest;
import com.campus.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserSignDaoTest extends BaseTest {
    @Autowired
    private UserSignDao userSignDao;


    @Test
    public void getSignByUser() {
        User user = new User();
        user.setUserId("o9NU95btTFCKFhkZY_4ETnjjrWfM");
    }

    @Test
    public void addUserSign() {
    }

    @Test
    public void getSigns() {
    }
}