package com.campus.entity;

import java.util.Date;

public class Lost {

    private Integer lostId;

    private User lostUser;

    private String lostContent;

    private Date createTime;

    private String contact;

    private User getUser;

    private Date getTime;

    private Integer getFlag;

    private Integer checkFlag;

    public Integer getLostId() {
        return lostId;
    }

    public void setLostId(Integer lostId) {
        this.lostId = lostId;
    }

    public User getLostUser() {
        return lostUser;
    }

    public void setLostUser(User lostUser) {
        this.lostUser = lostUser;
    }

    public String getLostContent() {
        return lostContent;
    }

    public void setLostContent(String lostContent) {
        this.lostContent = lostContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public User getGetUser() {
        return getUser;
    }

    public void setGetUser(User getUser) {
        this.getUser = getUser;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Integer getGetFlag() {
        return getFlag;
    }

    public void setGetFlag(Integer getFlag) {
        this.getFlag = getFlag;
    }

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }
}
