package com.campus.service;

import com.campus.dto.GoodsExcution;
import com.campus.entity.Goods;

public interface GoodsService {

    GoodsExcution addGoods(Goods goods);

    GoodsExcution changeGoods(Goods goods);

    GoodsExcution queryGoods();

    GoodsExcution serachGoods(String key);

    GoodsExcution findByCategory(String category);

}
