package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 1049. 最后一块石头的重量 II（中等）
 *
 * 有一堆石头，用整数数组 stones 表示，其中 stones[i] 表示第 i 块
 * 石头的重量。每一回合，从中选出任意两块石头粉碎：若重量相等，
 * 两块都被粉碎；若不等，较重的剩下两者之差，较轻的被粉碎。
 * 最多只会剩下一块石头，返回此石头最小的可能重量；若无剩余返回 0。
 *
 * 示例 1：
 *   输入：stones = [2, 7, 4, 1, 8, 1]
 *   输出：1
 *
 * 示例 2：
 *   输入：stones = [31, 26, 33, 21, 40]
 *   输出：5
 *
 * 提示：
 *   1 <= stones.length <= 30
 *   1 <= stones[i] <= 100
 *
 * 【学习要点】粉碎过程等价于把石头分成两堆，求两堆重量差最小。
 * 一堆尽量接近 sum/2 时差最小 → 0/1 背包：容量 sum/2 内能装的
 * 最大重量 best，答案 = sum - 2 * best。
 * 与 416 题互为表里：416 问能否完全平分，本题问最不平能剩多少。
 */
public class P14_Solution1049_LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
