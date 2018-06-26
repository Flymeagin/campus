package com.campus.dao;

import com.campus.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class GoodsCarDaoTest extends BaseTest{

    @Autowired
    private GoodsCarDao goodsCarDao;

    @Test
    public void addGoodsToCar() {
    }

    @Test
    public void removeGoodsToCar() {

    }

    @Test
    public void getCarByUserId() {
        System.out.println(goodsCarDao.getCarByUserId("o9NU95btTFCKFhkZY_4ETnjjrWfM").get(0).getUser().getNickName());
    }

    @Test
    public void getUserByGoodsId() {
    }

    @Test
    public void isExist() {
    }
}