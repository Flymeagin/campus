package com.campus.service.impl;

import com.campus.dao.GoodsCarDao;
import com.campus.entity.Goods;
import com.campus.entity.GoodsCar;
import com.campus.entity.User;
import com.campus.service.GoodsCarService;
import com.campus.utils.StringsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsCarServiceImpl implements GoodsCarService {

    @Autowired
    private GoodsCarDao goodsCarDao;

    @Override
    public boolean addGoodsCar(GoodsCar goodsCar) {
        if (goodsCar.getGoods() == null || goodsCar.getUser() == null ||
                StringsUtils.isNullOrEmpty(goodsCar.getUser().getUserId()) || goodsCar.getGoods().getGoodsId() <= 0) {
            throw new RuntimeException("参数为空");
        }
        //初始化
        goodsCar.setCreateTime(new Date());
        int resultNum = goodsCarDao.addGoodsToCar(goodsCar);
        if (resultNum <= 0) {
            throw new RuntimeException("内部错误,添加收藏失败!");
        }
        return true;
    }

    @Override
    public boolean removeGoodsCar(GoodsCar goodsCar) {
        if (goodsCar.getGoods() == null || goodsCar.getUser() == null ||
                StringsUtils.isNullOrEmpty(goodsCar.getUser().getUserId()) || goodsCar.getGoods().getGoodsId() <= 0) {
            throw new RuntimeException("参数为空");
        }
        int resultNum = goodsCarDao.removeGoodsToCar(goodsCar);
        if (resultNum <= 0) {
            throw new RuntimeException("内部错误,去除收藏失败!");
        }
        return true;
    }

    @Override
    public List<Goods> getGoodsCarById(String userId) {
        if(StringsUtils.isNullOrEmpty(userId)){
            throw  new RuntimeException("参数为空");
        }
        return goodsCarDao.getCarByUserId(userId);
    }

    @Override
    public List<User> getUserByGoodsId(int goodsId) {
        return null;
    }

    @Override
    public boolean isExist(String userId, int goodsId) {
        if(StringsUtils.isNullOrEmpty(userId)||goodsId<=0){
            throw  new RuntimeException("参数错误");
        }
        GoodsCar goodsCar = goodsCarDao.isExist(goodsId,userId);
        return goodsCar != null;
    }
}
