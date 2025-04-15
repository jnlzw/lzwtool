package com.jnlzw.lzwtool.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private ReentrantLock lock=new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void function1(){
        lock.lock();
        System.out.println("线程1开始执行");
        try {
            condition.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程1执行完毕");
        lock.unlock();
    }

    private void function2(){
        lock.lock();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程2开始执行");
        condition.signalAll();
        System.out.println("线程2执行完毕");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        new Thread(demo::function1).start();
        new Thread(demo::function2).start();
    }

}
