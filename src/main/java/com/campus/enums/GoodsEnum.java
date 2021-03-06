package com.campus.enums;

public enum GoodsEnum {

    INNER_ERROR(-1001,"内部错误"),
    NULL_USERID(-1002,"userId为空"),
    NULL_PARAM(-1003,"参数为空"),
    ILLEGAL_USERID(-1003,"userId非法"),
    FROZEN_USER(2,"用户被冻结"),
    SUCCESS(1,"操作成功");

    private int state;
    private String stateInfo;

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

    private GoodsEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public GoodsEnum stateOf(int state){
        for(GoodsEnum userEnum:values()){
            if(userEnum.getState() == state){
                return userEnum;
            }
        }
        return null;
    }

}
