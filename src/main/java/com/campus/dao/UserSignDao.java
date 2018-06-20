package com.campus.dao;

import com.campus.entity.Sign;
import com.campus.entity.User;
import com.campus.entity.UserSign;

import java.util.List;

public interface UserSignDao {


    //添加用户标签

    int addUserSign(UserSign userSign);


    //获取所有标签
    List<Sign> getSigns();

    //删除用户的所有标签

    int delUserSign(User user);
}
