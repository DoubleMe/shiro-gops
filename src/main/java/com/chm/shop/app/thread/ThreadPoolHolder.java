package com.chm.shop.app.thread;

import com.chm.shop.app.thread.impl.ApiLogWorker;
import com.chm.shop.app.thread.impl.SqlLogWorker;
import com.chm.shop.manager.log.dataobject.LogApiDO;
import com.chm.shop.manager.log.dataobject.LogSqlDO;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author chen-hongmin
 * @since 2017/11/8 17:46
 */

public class ThreadPoolHolder {

    public static final String SQL_LOG_THREAD = "sql_log_thread";
    public static final String API_LOG_THREAD = "api_log_thread";

    public static final int DEFAULT_POOL_SIZE = 1;
    /**
     * sql日志队列
     */
    public static ArrayBlockingQueue<LogSqlDO> sqlLogQueue = new ArrayBlockingQueue<>(1024 * 1024);

    /**
     * api 日志队列
     */
    public static ArrayBlockingQueue<LogApiDO> apiLogQueue = new ArrayBlockingQueue<>(1024 * 1024);

    public static ThreadManager<LogSqlDO> sqlLogManager = null;

    public static ThreadManager<LogApiDO> apiLogManager = null;

    static{
        initPool();
        start();
    }


    /**
     * 初始化现场池
     */
    private static void initPool() {
        ThreadPoolConfig sqlLogConfig = new ThreadPoolConfig(DEFAULT_POOL_SIZE, SQL_LOG_THREAD, sqlLogQueue, new SqlLogWorker());
        sqlLogManager = new ThreadManager(sqlLogConfig);

        ThreadPoolConfig apiLogConfig = new ThreadPoolConfig(DEFAULT_POOL_SIZE, API_LOG_THREAD, apiLogQueue, new ApiLogWorker());
        apiLogManager = new ThreadManager(apiLogConfig);
    }

    /**
     * 初始化 启动所有线程池
     */
    private static void start() {
        sqlLogManager.execute();
        apiLogManager.execute();
    }

}
