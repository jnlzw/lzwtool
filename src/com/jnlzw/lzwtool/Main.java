package com.jnlzw.lzwtool;

import org.omg.PortableInterceptor.INACTIVE;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzw on 2019/9/25.
 */
public class Main {

    static class cmp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

    public static void main(String[] args) {
        Sort sort=new Sort();
        Integer[] num={1,3,2,4};
        sort.heapSort(num,new cmp());
        System.out.println(Arrays.toString(num));
    }

}
