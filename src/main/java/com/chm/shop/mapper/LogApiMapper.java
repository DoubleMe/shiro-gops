package com.chm.shop.mapper;

import com.chm.shop.manager.log.dataobject.LogApiDO;
import com.chm.shop.manager.log.query.LogApiQuery;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;


public interface LogApiMapper {
    /**
     * 新增
     */
    int insert(LogApiDO logApiDO);

    /**
     * 更新
     */
    int update(LogApiDO logApiDO);

    /**
     * 主键查询
     */
    LogApiDO getById(Integer id);

    /**
     * 根据主键删除
     */
    int delById(Integer id);

    /**
     * 列表查询
     */
    PageList<LogApiDO> list(LogApiQuery query, PageBounds pageBounds);

}