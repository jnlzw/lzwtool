package com.jnlzw.lzwtool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by lzw on 2020/5/1
 */
public class Test implements Callable<String> {
    private int re=5;
    @Override
    public String call() throws Exception {
        System.out.println("执行call函数");
        if (re>0){
            Thread.sleep(500);
            System.out.println("re = " + re--);
        }
        return ""+re;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test test=new Test();
        Thread thread=new Thread(new FutureTask<>(test),"name");
        Thread thread2=new Thread(new FutureTask<>(test),"name2");
        Thread mainThread=Thread.currentThread();
        thread.start();
        thread2.start();
        System.out.println("mainThread.getPriority() = " + mainThread.getPriority());
        System.out.println("thread.getName() = " + thread.getName());
    }
}
