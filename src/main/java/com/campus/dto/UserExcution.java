package com.campus.dto;

import com.campus.entity.User;
import com.campus.enums.UserEnum;

import java.util.List;

public class UserExcution {

    private int state;
    private String stateInfo;
    private int count;
    private User user;
    private List<User> userList;
    //出错的逻辑
    public UserExcution(UserEnum userEnum){
        this.state = userEnum.getState();
        this.stateInfo = userEnum.getStateInfo();
    }
    //登录 注册的返回值
    public UserExcution(UserEnum userEnum,User user){
        this.state = userEnum.getState();
        this.stateInfo = userEnum.getStateInfo();
        this.user = user;
    }
    //获取所有用户
    public UserExcution(UserEnum userEnum,List<User> userList){
        this.state = userEnum.getState();
        this.stateInfo = userEnum.getStateInfo();
        this.userList = userList;
        this.count = userList.size();
    }




    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
