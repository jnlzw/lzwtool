package com.jnlzw.lzwtool.solutions.dp;

/**
 * 完全背包问题（基础模板，非 LeetCode 原题）
 *
 * 与 0/1 背包的唯一区别：每种物品有无限件，可以重复选择。
 *
 * 示例 1：
 *   输入：weights = [1, 3, 4], values = [15, 20, 30], capacity = 4
 *   输出：60
 *   解释：选 4 件物品 0，总重量 4，总价值 60。
 *   （若是 0/1 背包，答案只有 35。体会遍历顺序带来的差别。）
 *
 * 【学习要点】与 0/1 背包代码几乎一样，唯一区别是一维 dp
 * 【正序】遍历容量 j（weights[i] → capacity）。
 * 正序时 dp[j - weights[i]] 可能已经装过当前物品，
 * 正好表达"可重复选"的语义。
 * 求组合数见 518 题，求排列数见 377 题，二者只差内外循环顺序。
 */
public class P11_KnapsackComplete {

    public int knapsack(int[] weights, int[] values, int capacity) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
