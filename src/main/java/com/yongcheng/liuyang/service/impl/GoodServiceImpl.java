package com.yongcheng.liuyang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yongcheng.liuyang.dao.GoodMapper;
import com.yongcheng.liuyang.model.Goods;
import com.yongcheng.liuyang.model.Jqpage;
import com.yongcheng.liuyang.service.GoodsService;
@Service
public class GoodServiceImpl implements GoodsService
{
	private static final Logger logger = Logger.getLogger(GoodServiceImpl.class);
	
    @Resource
    private GoodMapper goodMapper;
    
    static
    {
    	System.out.println("加载service");
    	logger.info("加载service");
    }

    @Override
    @Transactional
    public List<Goods> getGoodsPager(Jqpage jqpage)
    {
        int pageNo = jqpage.getCurrentNo();
        int size = jqpage.getRows();
        int skip = (pageNo - 1)*size;
        return goodMapper.getGoodsPager(skip, size);
    }

    @Override
    public void insertIntoGoods(List<Goods> goods)
    {
        goodMapper.insertGoods(goods);
    }

    @Override
    public int getGoodsCount()
    {
        return goodMapper.getGoodsCount();
    }

    @Override
    public int deleteGoodById(int id)
    {
        return goodMapper.delete(id);
    }
    
}
