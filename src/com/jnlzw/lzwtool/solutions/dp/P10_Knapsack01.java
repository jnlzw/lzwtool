package com.jnlzw.lzwtool.solutions.dp;

/**
 * 0/1 背包问题（基础模板，非 LeetCode 原题）
 *
 * 有 n 件物品和一个容量为 capacity 的背包。第 i 件物品的重量是
 * weights[i]，价值是 values[i]。每件物品最多只能选一次（选或不选），
 * 求在不超过背包容量的前提下能获得的最大价值。
 *
 * 示例 1：
 *   输入：weights = [2, 3, 4, 5], values = [3, 4, 5, 6], capacity = 5
 *   输出：7
 *   解释：选物品 0 和物品 1，总重量 5，总价值 7。
 *
 * 【学习要点】一切背包问题的根基。
 * 状态：dp[j] = 容量为 j 的背包能装的最大价值。
 * 转移：dp[j] = max(dp[j], dp[j - weights[i]] + values[i])
 * 关键：一维滚动数组必须【倒序】遍历 j（capacity → weights[i]），
 * 正序会让同一件物品被重复计入，那就变成完全背包了。
 * 先想通二维 dp[i][j] 的含义，再压缩成一维。
 */
public class P10_Knapsack01 {

    public int knapsack(int[] weights, int[] values, int capacity) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
