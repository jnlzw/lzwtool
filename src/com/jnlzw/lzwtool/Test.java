package com.jnlzw.lzwtool;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lzw on 2020/5/1
 */
public class Test {
    public boolean fun(String str) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            if ('(' == str.charAt(i)) {
                deque.add(str.charAt(i));
            }
            if (')' == str.charAt(i)) {
                if (deque.size() == 0) return false;
                char remove = deque.removeFirst();
                if ('(' != remove) return false;
            }
        }
        return deque.size() == 0;
    }

    public static void main(String[] args) {
        Integer int1= 1000;
        Integer int2= 1000;
        Integer int3= 100;
        Integer int4= 100;

        System.out.println(int1==int2);
        System.out.println(int3==int4);
    }
}
