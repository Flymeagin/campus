package com.campus.service.impl;

import com.campus.dao.AdviceDao;
import com.campus.entity.Advice;
import com.campus.service.AdviceService;
import com.campus.utils.StringsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdviceServiceImpl implements AdviceService {


    @Autowired
    private AdviceDao adviceDao;

    @Override
    public boolean addAdvice(Advice advice) {
        try {
            if(StringsUtils.isNullOrEmpty(advice.getUser().getUserId())){
                return false;
            }
            advice.setCreateTime(new Date());
            int result = adviceDao.addAdvice(advice);
            return result > 0;
        } catch (Exception e) {
            throw  new RuntimeException("userId不存在");
        }
    }

    @Override
    public List<Advice> queryAdvice() {
        return null;
    }

    @Override
    public int count(String userId) {
        if(StringsUtils.isNullOrEmpty(userId)){
            return 0;
        }
        return adviceDao.getCount(userId);
    }
}
