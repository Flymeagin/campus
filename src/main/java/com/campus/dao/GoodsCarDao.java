package com.campus.dao;

import com.campus.entity.Goods;
import com.campus.entity.GoodsCar;
import com.campus.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCarDao {

    /**
     * 将商品添加进购物车
     *
     * @param goodsCar
     * @return
     */
    int addGoodsToCar(GoodsCar goodsCar);

    //将商品移出购物车
    int removeGoodsToCar(GoodsCar goodsCar);

    //根据用户的userId 返回用户的购物车
    List<Goods> getCarByUserId(String userId);

    //根据商品id获取用户列表
    List<User> getUserByGoodsId(int goodsId);


    //判断用户是否收藏此商品

    GoodsCar isExist(@Param("goodsId")int goodsId,@Param("userId")String userId);
}
