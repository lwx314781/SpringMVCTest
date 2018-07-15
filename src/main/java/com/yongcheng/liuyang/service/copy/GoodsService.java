package com.yongcheng.liuyang.service.copy;

import java.util.List;

import com.yongcheng.liuyang.model.Goods;
import com.yongcheng.liuyang.model.Jqpage;

public interface GoodsService
{
    List<Goods> getGoodsPager(Jqpage jqpage);
    
    int getGoodsCount();
    
    /**
     * 批量插入货物
     * @param goods
     */
    void insertIntoGoods(List<Goods> goods);
    
    
    int deleteGoodById(int id);
}
