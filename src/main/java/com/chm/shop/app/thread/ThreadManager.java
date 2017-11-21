package com.chm.shop.app.thread;

import java.util.concurrent.*;

/**
 * @author chen-hongmin
 * @since 2017/11/8 17:25
 */
public class ThreadManager<T> {

    private ThreadPoolConfig poolConfig;

    private Worker<T> worker;

    private ExecutorService executorService;

    public ThreadManager(ThreadPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
        this.worker = poolConfig.getWorker();
        this.worker.setQueue(poolConfig.getQueue());
        this.executorService = newThreadPoolExecutor(poolConfig.getPoolSize(), poolConfig.getThreadName());
    }

    /**
     * 创建线程池
     *
     * @param poolSize   线程池大小
     * @param threadName 线程名称
     * @return
     */
    public ExecutorService newThreadPoolExecutor(int poolSize, final String threadName) {


        ExecutorService executorService = new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1024), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName(threadName);
                return thread;
            }
        });

        return executorService;
    }

    /**
     * 执行
     */
    public void execute() {
        executorService.execute(worker);
    }

    /**
     * 添加任务
     */
    public void addQueue(T t) {
        worker.addQueue(t);
    }

}
