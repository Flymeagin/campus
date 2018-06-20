package com.campus.dao;

import com.campus.entity.GoodsCar;

public interface GoodsCarDao {

    /**
     * 将商品添加进购物车
     *
     * @param goodsCar
     * @return
     */
    int addGoodsToCar(GoodsCar goodsCar);

    int removeGoodsToCar(int goodsCarId);

}
