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

    public int[] searchRange(int[] A, int target) {
        // write code here
        int l = 0, r = A.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (A[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }
        int ansl = l;

        l = 0;
        r = A.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (A[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        int ansr = l;

        if (A[ansl] != target) ansl += 1;
        if (A[ansr] != target) ansr -= 1;
        // 不存在的情况
        if (ansl >= A.length || A[ansl] != target)
            ansl = ansr = -1;

        return new int[]{ansl, ansr};
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.searchRange(new int[]{1}, 0)[0]);
    }


}
