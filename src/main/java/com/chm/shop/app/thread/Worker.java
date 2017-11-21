package com.chm.shop.app.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

/**
 * @author chen-hongmin
 * @since 2017/11/10 10:50
 */
public abstract class Worker<T> implements Runnable {

    protected static final Logger logger = LoggerFactory.getLogger(Worker.class);

    /**
     * 任务队列
     */
    private BlockingQueue<T> queue;


    public Worker() {
    }

    public Worker(BlockingQueue queue) {
        this.queue = queue;
    }

    /**
     * 添加任务队列
     *
     * @param t
     */
    public void addQueue(T t) {
        queue.add(t);
    }

    @Override
    public void run() {

        try {
            while (true) {
                T take = queue.take();
                process(take);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BlockingQueue<T> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    protected abstract void process(T t);
}
