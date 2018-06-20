package com.campus.entity;

import java.util.Date;

public class EnterJob {

    private Integer enterJobId;

    private User user;

    private Job job;

    private Date createTime;

    public Integer getEnterJobId() {
        return enterJobId;
    }

    public void setEnterJobId(Integer enterJobId) {
        this.enterJobId = enterJobId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
