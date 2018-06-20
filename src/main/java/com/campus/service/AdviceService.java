package com.campus.service;

import com.campus.entity.Advice;

import java.util.List;

public interface AdviceService {

    boolean addAdvice(Advice advice);


    List<Advice> queryAdvice();

    int count(String userId);

}
