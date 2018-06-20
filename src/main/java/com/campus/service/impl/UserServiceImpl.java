package com.campus.service.impl;

import com.campus.dao.UserDao;
import com.campus.dao.UserSignDao;
import com.campus.dto.UserExcution;
import com.campus.entity.Sign;
import com.campus.entity.User;
import com.campus.entity.UserSign;
import com.campus.enums.UserEnum;
import com.campus.service.UserService;
import com.campus.utils.StringsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserSignDao userSignDao;

    @Override
    public UserExcution userLogin(User user) {

        //userId为空
        if (StringsUtils.isNullOrEmpty(user.getUserId())) {
            return new UserExcution(UserEnum.NULL_USERID);
        }
        //非第一次登录
        User queryUser = userDao.exist(user);
        if (queryUser != null) {
            if (queryUser.getFlag() == 0)
                return new UserExcution(UserEnum.SUCCESS, queryUser);
            else
                return new UserExcution(UserEnum.FROZEN_USER);
        } else {  //else 为用户第一次
            //初始化user相关
            user.setCreateTime(new Date());
            user.setLastEditTime(new Date());
            user.setDescription("该用户还木有签名哦~~~");
            user.setFlag(0);
            try {
                int effectNum = userDao.login(user);
                if (effectNum > 0) {
                    return new UserExcution(UserEnum.SUCCESS, user);
                } else {
                    throw new RuntimeException("用户登录失败!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("INNER_ERROR");
            }
        }

    }

    @Override
    public UserExcution queryUser() {
        return new UserExcution(UserEnum.SUCCESS, userDao.queryUser());
    }

    @Override
    @Transactional
    public UserExcution changeUser(User user, List<Sign> signs) {
        //userId为空
        if (StringsUtils.isNullOrEmpty(user.getUserId())) {
            return new UserExcution(UserEnum.NULL_USERID);
        }
        //初始化
        user.setLastEditTime(new Date());
        int effectNum = userDao.changeUser(user);
        if (effectNum <= 0) {
            throw new RuntimeException("更改用户失败!");
        }
        effectNum = userSignDao.delUserSign(user);
        //循环插入userSign
        for (Sign sign :signs){
            UserSign userSign = new UserSign();
            userSign.setSign(sign);
            userSign.setUser(user);
            effectNum = userSignDao.addUserSign(userSign);
            if(effectNum<=0){
                throw new RuntimeException("插入用户标签失败!");
            }
        }
        return new UserExcution(UserEnum.SUCCESS, user);

    }

    @Override
    public User exist(User user) {
        return userDao.exist(user);
    }
}
