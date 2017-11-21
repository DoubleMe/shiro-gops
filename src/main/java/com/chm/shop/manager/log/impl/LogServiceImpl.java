package com.chm.shop.manager.log.impl;

import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.common.reponse.ResponseCode;
import com.chm.shop.app.constants.MessageConstats;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.log.LogService;
import com.chm.shop.manager.log.dataobject.LogApiDO;
import com.chm.shop.manager.log.dataobject.LogSqlDO;
import com.chm.shop.manager.log.query.LogApiQuery;
import com.chm.shop.manager.log.query.LogSqlQuery;
import com.chm.shop.mapper.LogApiMapper;
import com.chm.shop.mapper.LogSqlMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/8 11:28
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogApiMapper logApiMapper;
    @Resource
    private LogSqlMapper logSqlMapper;

    @Override
    public void apiLog(LogApiDO logApiDO) {
        logApiMapper.insert(logApiDO);
    }

    @Override
    public void sqlLog(LogSqlDO logSqlDO) {
        logSqlMapper.insert(logSqlDO);
    }

    @Override
    public Response<LogApiDO> apiList(LogApiQuery query) {

        PageList<LogApiDO> list = logApiMapper.list(query, query.getPageBounds());
        return ResponseUtils.pageResponse(ResponseCode.SUCCESS, MessageConstats.SUCCESS, list);
    }

    @Override
    public Response<LogSqlDO> sqlList(LogSqlQuery query) {
        PageList<LogSqlDO> list = logSqlMapper.list(query, query.getPageBounds());
        return ResponseUtils.pageResponse(ResponseCode.SUCCESS, MessageConstats.SUCCESS, list);
    }
}
