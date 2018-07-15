package com.yongcheng.liuyang.model;

import java.io.Serializable;

public class Goods implements Serializable
{

    /**
     * 序列号
     */
    private static final long serialVersionUID = -7703815311382519577L;
    
    
    private int id;
    
    
    private String name;
    
    
    private double price;
    
    
    private String picture;
    

    public int getId()
    {
        return id;
    }


    public void setId(int id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public double getPrice()
    {
        return price;
    }


    public void setPrice(double price)
    {
        this.price = price;
    }


    public String getPicture()
    {
        return picture;
    }


    public void setPicture(String picture)
    {
        this.picture = picture;
    }
    
    
    @Override
    public String toString()
    {
        return "商品时：" + this.name + "价格是：" + this.price;
    }
    
}
