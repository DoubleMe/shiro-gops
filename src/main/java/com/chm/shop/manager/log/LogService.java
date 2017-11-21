package com.chm.shop.manager.log;

import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.log.dataobject.LogApiDO;
import com.chm.shop.manager.log.dataobject.LogSqlDO;
import com.chm.shop.manager.log.query.LogApiQuery;
import com.chm.shop.manager.log.query.LogSqlQuery;

/**
 * @author chen-hongmin
 * @since 2017/11/8 11:22
 */
public interface LogService {

    /**
     * 添加一条api日
     * @param logApiDO
     */
    void apiLog(LogApiDO logApiDO);

    /**
     * 添加一条sql日志
     * @param logSqlDO
     */
    void sqlLog(LogSqlDO logSqlDO);

    /**
     * api 日志列表
     * @return
     */
    Response<LogApiDO> apiList(LogApiQuery query);

    /**
     * sql 日志列表
     * @return
     */
    Response<LogSqlDO> sqlList(LogSqlQuery query);

}
