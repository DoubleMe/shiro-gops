package com.chm.shop.web.common.interceptor;


import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.constants.SystemConstants;
import com.chm.shop.app.thread.ThreadPoolHolder;
import com.chm.shop.app.util.JsonUtils;
import com.chm.shop.manager.log.LogService;
import com.chm.shop.manager.log.dataobject.LogApiDO;
import com.chm.shop.manager.log.dataobject.LogSqlDO;
import org.apache.commons.beanutils.BeanMap;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chen-hongmin on 2015/6/25.
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class}) })
public class SqlInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger("SQL");

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object[] args = invocation.getArgs();
        // 获取执行的方法
        if (args.length > 1) {

            MappedStatement mappedStatement = (MappedStatement) args[0];
            Object param = args[1];

            if (param instanceof LogApiDO || param instanceof  LogSqlDO){

            }else {
                BoundSql boundSql = mappedStatement.getBoundSql(args[1]);
                sqlLog(boundSql);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //TODO
    }

    /**
     * 添加到log 数据库中
     * @param boundSql
     */
    private void sqlLog(BoundSql boundSql){

        String sql = boundSql.getSql();
        //去除换行
        sql = sql.replaceAll(SystemConstants.lineSeparator, "");
        //去除空格
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(sql);
        String newSql = m.replaceAll(" ");

        BeanMap param = new BeanMap(boundSql.getParameterObject());
        Map<String,Object> parameters = new HashMap<>();
        for (Map.Entry<Object,Object> entry : param.entrySet()){
            if (entry.getKey().equals("class") || entry.getKey().equals("gmtCreated") || entry.getKey().equals("gmtModified")){
                continue;
            }
            parameters.put(entry.getKey().toString(),entry.getValue());
        }


        LogSqlDO logSqlDO = new LogSqlDO();
        logSqlDO.setSqlContent(newSql);
        logSqlDO.setParam(JsonUtils.ObjToJson(parameters));
        logSqlDO.setLoginId(UserTokenManager.getLoginId());

        ThreadPoolHolder.sqlLogManager.addQueue(logSqlDO);
    }
}
