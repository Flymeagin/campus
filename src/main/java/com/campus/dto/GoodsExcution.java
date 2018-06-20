package com.campus.dto;

import com.campus.entity.Goods;
import com.campus.enums.GoodsEnum;

import java.util.List;

public class GoodsExcution {

    private int state;

    private String stateInfo;

    private Goods goods;

    private List<Goods> goodsList;

    private int count;

    //操作失败的构造函数
    public  GoodsExcution(GoodsEnum goodsEnum){
        this.state = goodsEnum.getState();
        this.stateInfo = goodsEnum.getStateInfo();
    }

    public GoodsExcution(GoodsEnum goodsEnum,Goods goods){
        this.state = goodsEnum.getState();
        this.stateInfo = goodsEnum.getStateInfo();
        this.goods = goods;
    }

    public GoodsExcution(GoodsEnum goodsEnum,List<Goods> goodsList){
        this.state = goodsEnum.getState();
        this.stateInfo = goodsEnum.getStateInfo();
        this.count = goodsList.size();
        this.goodsList = goodsList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
