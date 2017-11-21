package com.chm.shop.app.thread;

import java.util.concurrent.BlockingQueue;

/**
 * @author chen-hongmin
 * @since 2017/11/10 14:51
 */
public class ThreadPoolConfig {

    /**
     * 线程名称
     */
    private String threadName;

    /**
     * 线程大小
     */
    private int poolSize;

    /**
     * 任务队列
     */
    private BlockingQueue queue;

    /**
     * 消费者
     */
    private Worker worker;

    public ThreadPoolConfig() {
    }

    public ThreadPoolConfig(Worker worker) {
        this.worker = worker;
    }

    public ThreadPoolConfig(String threadName, BlockingQueue queue, Worker worker) {
        this.threadName = threadName;
        this.queue = queue;
        this.worker = worker;
    }

    public ThreadPoolConfig(int poolSize, String threadName, BlockingQueue queue, Worker worker) {
        this.threadName = threadName;
        this.poolSize = poolSize;
        this.queue = queue;
        this.worker = worker;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public BlockingQueue getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue queue) {
        this.queue = queue;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }
}
