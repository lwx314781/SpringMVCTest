package com.yongcheng.liuyang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yongcheng.liuyang.model.Goods;

/**
 * 
 * 
 * @author Administrator
 *
 */
@Repository(value= "GoodMapper")
public interface GoodMapper
{
    /**
     * 获取商品信息并分页
     * @param skip
     * @param size
     * @return 商品信息总数
     */
    public List<Goods> getGoodsPager(@Param("skip") int skip,@Param("size") int size);
    
    /**
     * 获得商品总数
     */
    public int getGoodsCount();
    
    /**
     * 新增加商品
     */
    public int insert(Goods entity);
    
    
    /**
     * 删除商品
     */
    public int delete(int id);
    
    /**
     * 修改商品
     */
    public int update(Goods entity);
    
    //批量插入产品
    public void insertGoods(List<Goods> goods);
}
