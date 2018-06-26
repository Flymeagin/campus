package com.campus.service;

import com.campus.dto.GoodsExcution;
import com.campus.entity.Goods;

import java.util.*;

public interface GoodsService {

    GoodsExcution addGoods(Goods goods);

    GoodsExcution changeGoods(Goods goods);

    GoodsExcution queryGoods(int pageNum);

    GoodsExcution serachGoods(String key);

    GoodsExcution findByCategory(String category);

    Map<String, Object> indexGoods();

    GoodsExcution getGoodsByUser(String userId);

    GoodsExcution getGoodsById(int goodsId);

    boolean setBuyFlag(int goodsId,String userId);

    boolean delGoods(int goodsId,String userId);

}
