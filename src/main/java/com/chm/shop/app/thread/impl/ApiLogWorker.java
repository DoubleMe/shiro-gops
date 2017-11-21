package com.chm.shop.app.thread.impl;

import com.chm.shop.app.spring.SpringContext;
import com.chm.shop.app.thread.Worker;
import com.chm.shop.manager.log.LogService;
import com.chm.shop.manager.log.dataobject.LogApiDO;
import com.chm.shop.manager.log.dataobject.LogSqlDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author chen-hongmin
 * @since 2017/11/10 15:21
 */
@Component
public class ApiLogWorker extends Worker<LogApiDO> {


    @Override
    protected void process(LogApiDO logApiDO) {
        LogService logService = SpringContext.getBean(LogService.class);
        logService.apiLog(logApiDO);
    }
}
