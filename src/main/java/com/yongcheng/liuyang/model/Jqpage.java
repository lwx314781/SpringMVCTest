package com.yongcheng.liuyang.model;

import java.io.Serializable;

public class Jqpage implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -9033682220313598963L;

    /**
     * 总页数
     */
    private int totalPage;
    
    /**
     * 每页显示数量
     */
    private int pageSize = 10;
    
    /**
     * 当前页
     */
    private int currentNo;
    
    /**
     * 从第几个开始（用于分页）
     */
    private int startIndex;
    
    /**
     * 总数
     */
    private int count;
    
    /**
     * 请求行数
     */
    private int rows;
    
    
    private String search;
    
    public String getSearch()
    {
        return search;
    }

    public void setSearch(String search)
    {
        this.search = search;
    }

    /**
     * 用于排序的列名
     */
    private String sidx;
    
    private int nd;
    
    /**
     * 排序方式
     */
    private String sord;
    
    public String getSord()
    {
        return sord;
    }

    public void setSord(String sord)
    {
        this.sord = sord;
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public String getSidx()
    {
        return sidx;
    }

    public void setSidx(String sidx)
    {
        this.sidx = sidx;
    }

    public int getNd()
    {
        return nd;
    }

    public void setNd(int nd)
    {
        this.nd = nd;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public Jqpage(int currentNo,int rows,String sidx,String sord)
    {
        this.currentNo = currentNo;
        this.rows = rows;
        this.sidx = sidx;
        this.sord = sord;
    }
    
    public Jqpage(int currentNo,int pageSize)
    {
        this.currentNo = currentNo;
        this.pageSize =pageSize;
        this.startIndex = calcuteStartIndex();
    }
    
    public Jqpage()
    {
        super();
    }
    
    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getCurrentNo()
    {
        return currentNo;
    }

    public void setCurrentNo(int currentNo)
    {
        this.currentNo = currentNo;
    }

    public int getStartIndex()
    {
        return startIndex;
    }

    public void setStartIndex(int startIndex)
    {
        this.startIndex = startIndex;
    }
    
    private int calcuteStartIndex()
    {
        return (currentNo - 1)*pageSize;
    }
}
