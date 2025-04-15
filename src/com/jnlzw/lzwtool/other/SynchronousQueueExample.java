package com.jnlzw.lzwtool.other;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueExample {

    private static ThreadPoolExecutor executor =
            new ThreadPoolExecutor(2, 3, 1000, TimeUnit.SECONDS,
                    new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hello");
            });


        }
    }
}
