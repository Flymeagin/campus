package com.campus.dao;

import com.campus.entity.Goods;

import java.util.List;

public interface GoodsDao {


    /**
     * 查询商品
     * @param goods
     * @return
     */
    int addGoods(Goods goods);

    /**
     * 获取所有商品
     * @return
     */
    List<Goods>queryGoods();


    /**
     * 更改商品
     * @param goods
     * @return
     */
    int changeGoods(Goods goods);

    /**
     * 模糊查询
     * @param key
     * @return
     */
    List<Goods> searchGoods(String key);

    List<Goods> findByCategory(String category);
}
