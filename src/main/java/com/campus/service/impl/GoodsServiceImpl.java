package com.campus.service.impl;

import com.campus.dao.GoodsDao;
import com.campus.dto.GoodsExcution;
import com.campus.entity.Goods;
import com.campus.enums.GoodsEnum;
import com.campus.service.GoodsService;
import com.campus.utils.StringsUtils;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
            if(resultNum <= 0){
                throw  new RuntimeException("添加商品失败");
            }
            return new GoodsExcution(GoodsEnum.SUCCESS,goods);
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }

    }

    @Override
    public GoodsExcution changeGoods(Goods goods) {
        return null;
    }

    @Override
    public GoodsExcution queryGoods() {
        return null;
    }

    @Override
    public GoodsExcution serachGoods(String key) {
        return null;
    }

    @Override
    public GoodsExcution findByCategory(String category) {
        return null;
    }
}
