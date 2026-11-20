package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 416. 分割等和子集（中等）
 *
 * 给你一个只包含正整数的非空数组 nums。请你判断是否可以
 * 将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 *   输入：nums = [1, 5, 11, 5]
 *   输出：true
 *   解释：数组可以分割成 [1, 5, 5] 和 [11]。
 *
 * 示例 2：
 *   输入：nums = [1, 2, 3, 5]
 *   输出：false
 *   解释：数组不能分割成两个元素和相等的子集。
 *
 * 提示：
 *   1 <= nums.length <= 200
 *   1 <= nums[i] <= 100
 *
 * 【学习要点】0/1 背包"恰好装满"的可行性问题。
 * 总和为 sum 时，问题等价于：能否选出若干数恰好装满容量 sum/2
 * 的背包？sum 为奇数直接 false。
 * dp[j] 表示能否凑出和 j，转移 dp[j] |= dp[j - num]，倒序遍历。
 * 这是 494、1049 两道变体的前置思想。
 */
public class P13_Solution416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        // TODO: 在这里实现你的解法
        return false;
    }
}
