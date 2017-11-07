package com.chm.shop.app.common.query;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * @author chen-hongmin
 * @since 2017/10/31 13:48
 */
public class PageQuery {

    /**
     * 每页最多显示的记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 一页大小
     */
    protected int size;
    /**
     * 总记录数
     */
    protected int total;
    /**
     * 当前页数，从 0开始，0代表第一页
     */
    protected int page;

    /**
     * 总页数
     */
    protected int totalPage;

    public PageQuery() {
    }

    public PageQuery(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getSize() {

        if (size < 1 || size > 200){
            return DEFAULT_PAGE_SIZE;
        }
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        if (page < 1){
            return 0; //不需要分页
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {

        this.totalPage = (total + getSize() - 1) / getSize();
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    /**
     *  获取mybatis 分页参数
     * @return PageBounds
     */
    public PageBounds getPageBounds(){

        return new PageBounds(getPage(),getSize());
    }
}
