package com.campus.service;

import com.campus.entity.Sign;
import com.campus.entity.User;
import com.campus.entity.UserSign;

import java.util.List;

public interface UserSignService {


    boolean addUserSign(UserSign userSign);

    List<Sign> getSigns();
}
