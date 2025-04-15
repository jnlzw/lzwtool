package com.jnlzw.lzwtool.solutions.ac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.DelayQueue;

public class Solution14 {

    public int numberOfWeakCharacters(int[][] properties) {
        // 首先按攻击力排名
        Arrays.sort(properties, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        for (int i = 0; i < properties.length; i++) {
            for (int j = i+1;j< properties.length;j++){
                if(properties[i][1] < properties[j][1]){
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        // [[1,5],[10,4],[4,3]]
        int[][] properties = {{1,5},{10,4},{4,3}};
        System.out.println(solution.numberOfWeakCharacters(properties));
    }



}
