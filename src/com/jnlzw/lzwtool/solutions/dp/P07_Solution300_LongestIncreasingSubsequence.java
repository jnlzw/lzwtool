package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 300. 最长递增子序列（中等）
 *
 * 给你一个整数数组 nums，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而
 * 不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7]
 * 的子序列。
 *
 * 示例 1：
 *   输入：nums = [10,9,2,5,3,7,101,18]
 *   输出：4
 *   解释：最长递增子序列是 [2,3,7,101]，因此长度为 4。
 *
 * 示例 2：
 *   输入：nums = [0,1,0,3,2,3]
 *   输出：4
 *
 * 示例 3：
 *   输入：nums = [7,7,7,7,7,7,7]
 *   输出：1
 *
 * 提示：
 *   1 <= nums.length <= 2500
 *   -10^4 <= nums[i] <= 10^4
 *
 * 进阶：
 *   你能将算法的时间复杂度降低到 O(n log(n)) 吗？
 *
 * 【学习要点】LIS 是最经典的 DP 问题之一。
 * O(n²) 解法：dp[i] = 以 i 结尾的最长递增子序列长度，
 *   枚举 j < i，若 nums[j] < nums[i] 则 dp[i] = max(dp[i], dp[j]+1)。
 * O(n log n) 解法：维护一个"尾巴数组" tails，配合二分查找。
 * 建议先掌握 O(n²)，再挑战优化版本。
 */
public class P07_Solution300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
