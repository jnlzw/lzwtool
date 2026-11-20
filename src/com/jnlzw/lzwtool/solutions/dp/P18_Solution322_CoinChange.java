package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 322. 零钱兑换（中等）
 *
 * 给你一个整数数组 coins，表示不同面额的硬币；以及一个整数 amount，
 * 表示总金额。
 * 计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种
 * 硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 *   输入：coins = [1, 2, 5], amount = 11
 *   输出：3
 *   解释：11 = 5 + 5 + 1
 *
 * 示例 2：
 *   输入：coins = [2], amount = 3
 *   输出：-1
 *
 * 示例 3：
 *   输入：coins = [1], amount = 0
 *   输出：0
 *
 * 提示：
 *   1 <= coins.length <= 12
 *   1 <= coins[i] <= 2^31 - 1
 *   0 <= amount <= 10^4
 *
 * 【学习要点】完全背包问题（每种硬币无限使用）的变形，求最小数量。
 * dp[i] = 凑成金额 i 所需的最少硬币数。
 * dp[i] = min(dp[i - coin] + 1) 对所有 coin <= i。
 * 注意初始化值的选择和"不可达"状态的表示。
 */
public class P18_Solution322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
