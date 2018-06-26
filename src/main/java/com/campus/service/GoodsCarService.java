package com.campus.service;

import com.campus.entity.Goods;
import com.campus.entity.GoodsCar;
import com.campus.entity.User;

import java.util.List;

public interface GoodsCarService {


    boolean addGoodsCar(GoodsCar goodsCar);

    boolean removeGoodsCar(GoodsCar goodsCar);

    List<Goods> getGoodsCarById(String userId);

    List<User> getUserByGoodsId(int goodsId);

    boolean isExist(String userId,int goodsId);

}
