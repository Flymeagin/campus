package com.campus.service.impl;

import com.campus.dao.UserSignDao;
import com.campus.entity.Sign;
import com.campus.entity.User;
import com.campus.entity.UserSign;
import com.campus.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSignServiceImpl implements UserSignService {

    @Autowired
    private UserSignDao userSignDao;

    @Override
    public boolean addUserSign(UserSign userSign) {
        return userSignDao.addUserSign(userSign) > 0;
    }

    @Override
    public List<Sign> getSigns() {
        return userSignDao.getSigns();
    }
}
