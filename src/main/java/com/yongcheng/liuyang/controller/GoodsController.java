package com.yongcheng.liuyang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yongcheng.liuyang.model.BaseModel;
import com.yongcheng.liuyang.model.Goods;
import com.yongcheng.liuyang.model.Jqpage;
import com.yongcheng.liuyang.service.GoodsService;

/**
 * 物品控制器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsController
{
	private static final Logger logger = Logger.getLogger(GoodsController.class);
	
    @Resource
    private GoodsService goodsService;
    
    static {
    	System.out.println("加载controller");
    	logger.info("加载controller");
    }
    
    @RequestMapping(value="/queryList")
    @ResponseBody
    public BaseModel<Goods> getGoodsList(@RequestParam(name="currentNo",defaultValue="1",required=false) int page,
            @RequestParam(name="rows",required=false,defaultValue="10") int rows,
            @RequestParam(name="sidx",required=false) String sidx,
            @RequestParam(name="sord",required=false) String sord)
    {
        Jqpage jqpage = new Jqpage(page, rows, sidx, sord);
        List<Goods> list = new ArrayList<Goods>();
        int count = goodsService.getGoodsCount();
        jqpage.setCount(count);
        if (count>0)
        {
            list = goodsService.getGoodsPager(jqpage);
        }
        BaseModel<Goods> baseData = new BaseModel<Goods>();
        baseData.setList(list);
        baseData.setCount(count);
        baseData.setCurrentNo(page);
        baseData.setRows(rows);
        return baseData;
    }
    
    @RequestMapping(value="/shwoInfo")
    public String showPageInfo()
    {
        return "good";
    }
    
}
