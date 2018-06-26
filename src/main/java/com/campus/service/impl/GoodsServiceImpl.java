package com.campus.service.impl;

import com.campus.dao.GoodsDao;
import com.campus.dto.GoodsExcution;
import com.campus.dto.UserExcution;
import com.campus.entity.Goods;
import com.campus.enums.GoodsEnum;
import com.campus.enums.UserEnum;
import com.campus.service.GoodsService;
import com.campus.utils.StringsUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public GoodsExcution addGoods(Goods goods) {
        //用户Id为空
        if (StringsUtils.isNullOrEmpty(goods.getUser().getUserId())) {
            return new GoodsExcution(GoodsEnum.NULL_USERID);
        }
        //参数为空
        if (StringsUtils.isNullOrEmpty(goods.getContact()) || StringsUtils.isNullOrEmpty(goods.getGoodsContent())
                || StringsUtils.isNullOrEmpty(goods.getGoodsTitle()) || StringsUtils.isNullOrEmpty(goods.getGoodsCategory())
                || StringsUtils.isNullOrEmpty(goods.getGoodsImg())
                ) {
            return new GoodsExcution(GoodsEnum.NULL_PARAM);
        }
        //设置初始值
        goods.setCreateTime(new Date());
        try {
            int resultNum = goodsDao.addGoods(goods);
            if (resultNum <= 0) {
                throw new RuntimeException("添加商品失败");
            }
            return new GoodsExcution(GoodsEnum.SUCCESS, goods);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public GoodsExcution changeGoods(Goods goods) {
        if(goods.getGoodsId()<=0||goods.getUser()==null||StringsUtils.isNullOrEmpty(goods.getUser().getUserId())){
            return new GoodsExcution(GoodsEnum.NULL_PARAM);
        }
        int resultNum = goodsDao.changeGoods(goods);
        if(resultNum<=0){
            throw  new RuntimeException("更改失败!");
        }
        return  new GoodsExcution(GoodsEnum.SUCCESS,goods);
    }

    @Override
    public GoodsExcution queryGoods(int pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Goods> goodsList = goodsDao.queryGoods();
        return  new GoodsExcution(GoodsEnum.SUCCESS,goodsList);
    }

    @Override
    public GoodsExcution serachGoods(String key) {
        List<Goods> goodsList = goodsDao.searchGoods(key);
        return new GoodsExcution(GoodsEnum.SUCCESS, goodsList);
    }

    @Override
    public GoodsExcution findByCategory(String category) {
        List<Goods> goodsList = goodsDao.findByCategory(category);
        return new GoodsExcution(GoodsEnum.SUCCESS, goodsList);
    }

    @Override
    public Map<String, Object> indexGoods() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("mostview", goodsDao.getGoodsByViewNum());
        maps.put("latest", goodsDao.getGoodsByTime());
        return maps;
    }

    @Override
    public GoodsExcution getGoodsByUser(String userId) {
        if (StringsUtils.isNullOrEmpty(userId)) {
            return new GoodsExcution(GoodsEnum.NULL_USERID);
        }
        return new GoodsExcution(GoodsEnum.SUCCESS, goodsDao.getGoodsByUserId(userId));
    }

    @Transactional
    @Override
    public GoodsExcution getGoodsById(int goodsId) {
        if (goodsId <= 0) {
            return new GoodsExcution(GoodsEnum.NULL_PARAM);
        }
        Goods goods = goodsDao.getGoodsById(goodsId);
        if (goods == null) {
            throw new RuntimeException("参数错误");
        }
        int resultNum = goodsDao.setViewNum(goodsId);
        if (resultNum <= 0) {
            throw new RuntimeException("增加访问量出错!");
        }
        return new GoodsExcution(GoodsEnum.SUCCESS, goods);
    }

    @Override
    public boolean setBuyFlag(int goodsId,String userId) {
        if (goodsId <= 0) {
            throw new RuntimeException("参数为空");
        }
        int resultNum = goodsDao.setBuyFlag(goodsId,userId);
        if (resultNum <= 0) {
            throw new RuntimeException("设置卖出状态失败!");
        }
        return true;
    }

    @Override
    public boolean delGoods(int goodsId,String userId) {
        if (goodsId <= 0) {
            throw new RuntimeException("参数为空");
        }
        int resultNum = goodsDao.delGoodsById(goodsId,userId);
        if (resultNum <= 0) {
            throw  new RuntimeException("删除商品失败!");
        }
        return true;
    }
}
