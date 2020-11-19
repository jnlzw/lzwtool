package com.jnlzw.lzwtool;

import com.sun.javafx.image.impl.IntArgb;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by lzw on 2019/9/25.
 */



public class Main {
    public static void main(String[] args) {
        List<Integer> test=new ArrayList<>();
        test.add(1);
        test.add(2);
        Integer a=test.get(0);
        a=100;
        test.forEach(System.out::println);
    }
}
