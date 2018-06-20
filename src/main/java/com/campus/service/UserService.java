package com.campus.service;

import com.campus.dto.UserExcution;
import com.campus.entity.Sign;
import com.campus.entity.User;

import java.util.List;

public interface UserService {

    UserExcution userLogin(User user);

    UserExcution queryUser();

    UserExcution changeUser(User user, List<Sign> signs);

    User exist(User user);

}
