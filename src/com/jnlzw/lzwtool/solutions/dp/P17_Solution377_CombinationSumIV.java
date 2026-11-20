package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 377. 组合总和 IV（中等）
 *
 * 给你一个由不同整数组成的数组 nums 和一个目标整数 target。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 注意：顺序不同的序列被视作不同的组合（实为排列）。
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 示例 1：
 *   输入：nums = [1, 2, 3], target = 4
 *   输出：7
 *   解释：(1,1,1,1) (1,1,2) (1,2,1) (2,1,1) (2,2) (1,3) (3,1)。
 *
 * 示例 2：
 *   输入：nums = [9], target = 3
 *   输出：0
 *
 * 提示：
 *   1 <= nums.length <= 200
 *   1 <= nums[i] <= 1000
 *   1 <= target <= 1000
 *
 * 进阶：如果给定的数组中含有负数会发生什么？
 *
 * 【学习要点】完全背包"排列数"问题。
 * 与 518 题唯一的差别：本题 (1,3) 与 (3,1) 算两种方案。
 * 解法上体现为内外循环颠倒——【外层正序遍历容量、内层遍历物品】，
 * dp[i] += dp[i - num]。
 * 背包九讲里最经典的对比题：组合数外物品内容量，
 * 排列数外容量内物品。想清楚为什么，遍历顺序就再也不用背了。
 */
public class P17_Solution377_CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
