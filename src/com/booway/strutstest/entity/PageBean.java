package com.booway.strutstest.entity;

import java.util.List;

/**
 * 分页对象
 * @author Administrator
 *
 * @param <T>
 */
public class PageBean<T>
{
    private int currentPage;
    private List<T> pageDate;
    private int currentCount;
    private int totalPage;

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public List<T> getPageDate()
    {
        return pageDate;
    }

    public void setPageDate(List<T> pageDate)
    {
        this.pageDate = pageDate;
    }

    public int getCurrentCount()
    {
        return currentCount;
    }

    public void setCurrentCount(int currentCount)
    {
        this.currentCount = currentCount;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

}
