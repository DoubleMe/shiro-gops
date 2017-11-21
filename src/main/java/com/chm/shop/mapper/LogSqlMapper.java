package com.chm.shop.mapper;

import com.chm.shop.manager.log.dataobject.LogSqlDO;
import com.chm.shop.manager.log.query.LogSqlQuery;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;


public interface LogSqlMapper {
    /**
     * 新增
     */
    int insert(LogSqlDO logSqlDO);

    /**
     * 更新
     */
    int update(LogSqlDO logSqlDO);

    /**
     * 主键查询
     */
    LogSqlDO getById(Integer id);

    /**
     * 根据主键删除
     */
    int delById(Integer id);

    /**
     * 列表查询
     */
    PageList<LogSqlDO> list(LogSqlQuery query, PageBounds pageBounds);

}