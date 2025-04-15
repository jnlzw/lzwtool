package com.jnlzw.lzwtool.solutions.ac;

import java.util.ArrayList;
import java.util.List;

public class Solution11 {
    private List<List<Integer>> findWinners(int[][] matches) {
        int[] ufs = new int[100000];

        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0];
            int losee = matches[i][1];
            if (ufs[win] == 0) {
                ufs[win] = win;
            }
            if (ufs[losee] == 0) {
                ufs[losee] = losee;
            }

            if (ufs[losee] == losee){
                // 还没输过
                ufs[losee] = win;
            }else if (ufs[win] == -1){
                // 已经输过不止一次 直接返回
            }else {
                // 已经输过一次  至为-1
                ufs[losee] = -1;
            }
        }

        List<Integer> winners = new ArrayList<>();
        List<Integer> loseers = new ArrayList<>();
        for (int i = 0; i < ufs.length; i++) {
            if (ufs[i] == -1) {
            }else if (ufs[i] == 0) {
            }else if (ufs[i] == i) {
                winners.add(i);
            }else {
                loseers.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(winners);
        return result;
    }

    public static void main(String[] args) {
        Solution11 solution = new Solution11();
        // [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> result = solution.findWinners(matches);
    }
}
