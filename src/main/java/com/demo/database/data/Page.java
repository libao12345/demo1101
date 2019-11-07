package com.demo.database.data;

import java.io.Serializable;

/**
 * 分页的持久化类
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月06日 16:04：12
 */
public class Page implements Serializable {

    private int pageNow = 1; // 当前页数
    private int pageSize = 4; // 每页显示记录的条数
    private int totalCount; // 总的记录条数
    private int totalPageCount; // 总的页数
    @SuppressWarnings("unused")
    private int startPos; // 开始位置，从0开始

    public Page(int totalCount, int pageNow) {
        this.totalCount = totalCount;
        this.pageNow = pageNow;
    }

    /**
     * 获得总页数
     * @return
     */
    public int getTotalPageCount() {
        totalPageCount = getTotalCount()/getPageSize();
        return (getTotalCount() % getPageSize()==0 ? totalPageCount : totalPageCount+1);
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }
}
