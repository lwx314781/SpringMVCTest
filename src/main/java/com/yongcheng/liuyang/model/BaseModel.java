package com.yongcheng.liuyang.model;

import java.util.List;

public class BaseModel<T>
{
    private List<T> list;
    
    private int currentNo;
    
    private int count;
    
    private int rows;

    public List<T> getList()
    {
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }

    public int getCurrentNo()
    {
        return currentNo;
    }

    public void setCurrentNo(int currentNo)
    {
        this.currentNo = currentNo;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }
}
