package com.jnlzw.lzwtool;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by lzw on 2019/9/25.
 */
public class Main {

    static class cmp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }


    public static void main(String[] args) {
//        Sort sort=new Sort();
//        Integer [] num={1,3,2,4,6,1,2,8,4,9,7};
//        //Comparator<Integer> Cmp = Comparator.comparingInt(o -> o); //lambda写法
//        //堆排序有bug
//        sort.heapSort(num,new cmp());
//        System.out.println(Arrays.toString(num));

        System.out.println(1034170131 % 4);
        System.out.println(1034170131 / 4);
        System.out.println(258542532 * 4 + 3);
    }
}
