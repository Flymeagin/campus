package com.campus.dao;

import com.campus.entity.Advice;

import java.util.List;

public interface AdviceDao {

    int addAdvice(Advice advice);

    //查询所有建议
    List<Advice> queryAdvice();

    // 得到用户的条数

    int getCount(String userId);

}
