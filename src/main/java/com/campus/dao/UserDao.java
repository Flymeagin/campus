package com.campus.dao;

import com.campus.entity.Sign;
import com.campus.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 判断用户是否存在
     * @param user
     * @return
     */
    User exist(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    int login(User user);

    /**
     * 获取所有用户
     * @return
     */
    List<User> queryUser();

    /**
     * 更改用户
     * @param user
     * @return
     */
    int changeUser(User user);

    List<Sign> getSignByUser();
}
