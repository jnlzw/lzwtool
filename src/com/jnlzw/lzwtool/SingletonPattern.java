package com.jnlzw.lzwtool;

/**
 * Created by lzw on 2020/4/28.
 */
// patterns/SingletonPattern.java
interface Resource {
    int getValue();
    void setValue(int x);
}

/*
 * 由于这不是从Cloneable基类继承而且没有添加可克隆性，
 * 因此将其设置为final可防止通过继承添加可克隆性。
 * 这也实现了线程安全的延迟初始化：
 */
final class Singleton {
    private static final class ResourceImpl implements Resource {
        private int i;
        private ResourceImpl(int i) {
            this.i = i;
        }
        public synchronized int getValue() {
            return i;
        }
        public synchronized void setValue(int x) {
            i = x;
        }
    }

    private static class ResourceHolder {
        private static Resource resource = new ResourceImpl(47);
    }
    public static Resource getResource() {
        return ResourceHolder.resource;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Resource r = Singleton.getResource();
        System.out.println(r.getValue());
        Resource s2 = Singleton.getResource();
        s2.setValue(9);
        System.out.println(r.getValue());
    }
} /* Output: 47 9 */
