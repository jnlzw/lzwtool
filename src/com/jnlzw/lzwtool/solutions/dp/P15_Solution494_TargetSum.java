package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 494. 目标和（中等）
 *
 * 给你一个整数数组 nums 和一个整数 target。向数组中的每个整数前
 * 添加 '+' 或 '-'，然后串联起所有整数，可以构造一个表达式。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同表达式
 * 的数目。
 *
 * 示例 1：
 *   输入：nums = [1, 1, 1, 1, 1], target = 3
 *   输出：5
 *
 * 示例 2：
 *   输入：nums = [1], target = 1
 *   输出：1
 *
 * 提示：
 *   1 <= nums.length <= 20
 *   0 <= nums[i] <= 1000
 *   -1000 <= target <= 1000
 *
 * 【学习要点】0/1 背包"装满方案数"问题。
 * 设正数集合和为 P，负数集合和为 N：
 *   P - N = target，P + N = sum  →  P = (sum + target) / 2
 * 问题转化为：有多少种选法能恰好装满容量 P 的背包？
 * dp[j] = 凑出 j 的方案数，dp[j] += dp[j - num]，dp[0] = 1。
 * 注意 (sum + target) 为奇数或 target 绝对值大于 sum 时无解。
 */
public class P15_Solution494_TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
