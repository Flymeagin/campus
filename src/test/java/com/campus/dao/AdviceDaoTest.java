package com.campus.dao;

import com.campus.BaseTest;
import com.campus.entity.Advice;
import com.campus.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class AdviceDaoTest extends BaseTest {

    @Autowired
    private AdviceDao adviceDao;

    @Test
    public void addAdvice() {
        Advice advice = new Advice();
        advice.setAdviceContent("界面能好看点么");
        advice.setCreateTime(new Date());
        User user = new User();
        user.setUserId("o9NU95btTFCKFhkZY_4ETnjjrWfM");
        advice.setUser(user);
        adviceDao.addAdvice(advice);
    }

    @Test
    public void queryAdvice() {
        System.out.println(adviceDao.queryAdvice().get(0).getUser().getNickName());
    }
}