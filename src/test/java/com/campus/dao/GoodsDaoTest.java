package com.campus.dao;

import com.campus.BaseTest;
import com.campus.entity.Goods;
import com.campus.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class GoodsDaoTest extends BaseTest {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    public void addGoods() {
        Goods goods = new Goods();
        User user = new User();
        user.setUserId("o9NU95btTFCKFhkZY_4ETnjjrWfM");
        goods.setUser(user);
        goods.setGoodsTitle("hello");
        goods.setGoodsPrice(19.0f);
        goods.setGoodsContent("test");
        goods.setContact("11709");
        goods.setCreateTime(new Date());
        goods.setGoodsCategory("hello");
        goods.setGoodsImg("12312321");
        goodsDao.addGoods(goods);
    }

    @Test
    public void queryGoods() {
        System.out.println(goodsDao.queryGoods().get(0).getContact());
    }

    @Test
    public void changeGoods() {
    }

    @Test
    public void searchGoods() {
        System.out.println(goodsDao.searchGoods("s").size());
    }

    @Test
    public void findByCategory() {
        System.out.println(goodsDao.findByCategory("手机/数码").get(0).getGoodsTitle());
    }

    @Test
    public void queryGoods1() {
    }

    @Test
    public void changeGoods1() {
    }

    @Test
    public void searchGoods1() {
    }

    @Test
    public void findByCategory1() {
    }

    @Test
    public void getGoodsByViewNum() {
    }

    @Test
    public void getGoodsByTime() {
    }
}