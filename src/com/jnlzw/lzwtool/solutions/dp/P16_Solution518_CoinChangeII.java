package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 518. 零钱兑换 II（中等）
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数
 * amount 表示总金额。请你计算并返回可以凑成总金额的硬币组合数。
 * 如果任何硬币组合都无法凑出总金额，返回 0。
 * 假设每种面额的硬币有无限个。题目数据保证结果符合 32 位整数。
 *
 * 示例 1：
 *   输入：amount = 5, coins = [1, 2, 5]
 *   输出：4
 *   解释：5=5，5=2+2+1，5=2+1+1+1，5=1+1+1+1+1。
 *
 * 示例 2：
 *   输入：amount = 3, coins = [2]
 *   输出：0
 *
 * 示例 3：
 *   输入：amount = 10, coins = [10]
 *   输出：1
 *
 * 提示：
 *   1 <= coins.length <= 300
 *   1 <= coins[i] <= 5000
 *   0 <= amount <= 5000
 *
 * 【学习要点】完全背包"装满方案数"问题。
 * dp[j] = 凑成金额 j 的组合数，dp[j] += dp[j - coin]，dp[0] = 1。
 * 必须【外层遍历物品、内层正序容量】——保证每种硬币按序加入，
 * {1,2} 和 {2,1} 只算同一种组合。
 * 若内外循环颠倒就变成排列数，即 377 题。两题对比着做。
 */
public class P16_Solution518_CoinChangeII {

    public int change(int amount, int[] coins) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
