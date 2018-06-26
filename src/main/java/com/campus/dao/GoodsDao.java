package com.campus.dao;

import com.campus.entity.Goods;
import org.apache.ibatis.annotations.Param;

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


    //获得人气高的商品
    List<Goods> getGoodsByViewNum();

    //获取最新发布的前三
    List<Goods> getGoodsByTime();

    //根据商品Id返回商品信息
    Goods getGoodsById(int goodsId);

    //返回一个用户的所有商品
    List<Goods> getGoodsByUserId(String userId);

    //用户设置商品为已售出
    int setBuyFlag(@Param("goodsId") int goodsId,@Param("userId") String userId);

    //谁知访问量+1
    int setViewNum(int goodsId);


    //删除商品
    int delGoodsById(@Param("goodsId") int goodsId,@Param("userId") String userId);

}
