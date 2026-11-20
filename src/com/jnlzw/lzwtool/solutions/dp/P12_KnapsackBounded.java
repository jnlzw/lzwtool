package com.jnlzw.lzwtool.solutions.dp;

/**
 * 多重背包问题（基础模板，非 LeetCode 原题）
 *
 * 与 0/1 背包的区别：第 i 种物品最多有 counts[i] 件可用。
 * 求在不超过背包容量的前提下能获得的最大价值。
 *
 * 示例 1：
 *   输入：weights = [1, 2, 3], values = [6, 10, 12],
 *         counts = [2, 1, 2], capacity = 5
 *   输出：24
 *   解释：选 2 件物品 0 和 1 件物品 2，总重量 5，总价值 24。
 *
 * 【学习要点】两种解法：
 * 1. 朴素：在 0/1 的内层再加一重循环 k（取 0..counts[i] 件），
 *    dp[j] = max(dp[j], dp[j - k*w] + k*v)。
 * 2. 二进制拆分：把 c 件同种物品拆成 1, 2, 4, ..., 剩余 个
 *    "打包物品"，转成 0/1 背包，复杂度 O(capacity * Σlog count)。
 * 建议先写朴素版跑对，再挑战拆分版。
 */
public class P12_KnapsackBounded {

    public int knapsack(int[] weights, int[] values, int[] counts, int capacity) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
