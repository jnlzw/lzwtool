package com.jnlzw.lzwtool.java;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ThreadLocal示例类
 * <p>
 * 该类演示了ThreadLocal的基本使用方法和特性：
 * 1. ThreadLocal变量在不同线程中是相互隔离的
 * 2. 即使在线程池中重用线程，ThreadLocal也能保持数据隔离
 * 3. 演示了ThreadLocal的设置、获取和清理操作
 */
public class ThreadLocalDemo {

    /**
     * ThreadLocal实例，用于存储String类型的线程本地变量
     * 每个线程都会有自己独立的存储空间，互不干扰
     */
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * 创建一个单线程的线程池
     * - corePoolSize = 1：核心线程数为1
     * - maximumPoolSize = 1：最大线程数为1
     * - keepAliveTime = 0L：多余的空闲线程会被立即终止
     * - workQueue：使用容量为1的LinkedBlockingQueue作为工作队列
     */
    private static ThreadPoolExecutor singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue<Runnable>(1));

    /**
     * 主方法，演示ThreadLocal的使用
     * 通过两个任务展示ThreadLocal变量的设置和获取
     */
    public static void main(String[] args) {

        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("123");
            }
        });

        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                String s = threadLocal.get();
                System.out.println("s = " + s);
                threadLocal.remove();
            }
        });
    }

}

