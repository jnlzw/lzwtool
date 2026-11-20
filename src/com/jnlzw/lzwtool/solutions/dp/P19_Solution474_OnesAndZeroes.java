package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 474. 一和零（中等）
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m、n。请你找出并返回
 * strs 的最大子集的长度，该子集中最多有 m 个 '0' 和 n 个 '1'。
 *
 * 示例 1：
 *   输入：strs = ["10","0001","111001","1","0"], m = 5, n = 3
 *   输出：4
 *   解释：最大子集为 {"10","0001","1","0"}。
 *
 * 示例 2：
 *   输入：strs = ["10","0","1"], m = 1, n = 1
 *   输出：2
 *
 * 提示：
 *   1 <= strs.length <= 600
 *   1 <= strs[i].length <= 100
 *   strs[i] 仅由 '0' 和 '1' 组成
 *   1 <= m, n <= 100
 *
 * 【学习要点】二维费用 0/1 背包。
 * 普通背包只有一个容量维度；本题每件"物品"（字符串）同时消耗
 * 两种费用：0 的个数和 1 的个数。
 * dp[i][j] = 用 i 个 0、j 个 1 能装下的最大子集长度，
 * 两个维度都要倒序遍历（仍然是 0/1 背包）。
 * 背包容量可以不止一维，抓住"费用"和"价值"就不会被吓到。
 */
public class P19_Solution474_OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
