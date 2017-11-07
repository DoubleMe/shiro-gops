
package com.chm.shop.app.common.reponse;


/**
 * @author jisc
 * @Type QueryResultDO
 * @Desc
 * @date 2014年2月11日
 * @Version V1.0
 */
public class PageResponse<T> extends Response<T> {

    /**
     * 默认每页显示的记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 总数
     */
    private int total = 0;

    /**
     * 一页大小
     */
    private int pageSize;

    /**
     * 当前页数，从 0开始，0代表第一页
     */
    private int pageIndex;

    /**
     * 总页数
     */
    private int totalPage;

    public PageResponse() {

    }

    public PageResponse(int pageIndex, int pageSize, int total, T data) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        setTotal(total);
        setData(data);
    }

    /**
     * 总数
     */
    public int getTotal() {
        return total;
    }

    /**
     * 总数
     */
    public void setTotal(int total) {
        this.totalPage = (total + getPageSize() - 1) / getPageSize();
        this.total = total;
    }

    /**
     * 获取一页的记录数
     *
     * @return
     */
    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    /**
     * 设置一页的记录数
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 得到当前查询的第几页
     *
     * @return
     */
    public int getPageIndex() {
        if (pageIndex < 1) {
            pageIndex = 1;
        } else if (pageIndex > getTotalPage()) {
            pageIndex = getTotalPage();
        }
        return pageIndex;
    }

    /**
     * 是否有下页
     *
     * @return
     */
    public boolean hasNextPage() {
        if (pageIndex < getTotalPage()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 设置当前页面
     *
     * @param pageIndex
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * 得到总页数
     *
     * @return
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 设置分页信息
     *
     * @param pageIndex  当前页码
     * @param pageSize   每页多少数据
     * @param total      总数量
     * @param dataResult 当前页结果数据
     */
    public void setPageResult(int pageIndex, int pageSize, int total, T dataResult) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        setTotal(total);
        setData(dataResult);
    }
}
