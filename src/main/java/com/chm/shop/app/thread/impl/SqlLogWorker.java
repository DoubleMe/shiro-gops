package com.chm.shop.app.thread.impl;

import com.chm.shop.app.spring.SpringContext;
import com.chm.shop.app.thread.Worker;
import com.chm.shop.manager.log.LogService;
import com.chm.shop.manager.log.dataobject.LogSqlDO;

/**
 * @author chen-hongmin
 * @since 2017/11/10 15:21
 */

public class SqlLogWorker extends Worker<LogSqlDO> {


    @Override
    protected void process(LogSqlDO logSqlDO) {

        LogService logService = SpringContext.getBean(LogService.class);
        logService.sqlLog(logSqlDO);
    }
}
