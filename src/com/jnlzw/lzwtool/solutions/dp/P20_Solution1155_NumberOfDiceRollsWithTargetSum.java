package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 1155. 掷骰子等于目标和的方法数（中等）
 *
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为
 * 1 到 k。给定三个整数 n、k 和 target，返回可能的方式
 * （从总共 k^n 种方式中）滚动出的数字和恰好等于 target 的
 * 方案数。答案可能很大，对 10^9 + 7 取模后返回。
 *
 * 示例 1：
 *   输入：n = 1, k = 6, target = 3
 *   输出：1
 *
 * 示例 2：
 *   输入：n = 2, k = 6, target = 7
 *   输出：6
 *
 * 示例 3：
 *   输入：n = 30, k = 30, target = 500
 *   输出：222616187
 *
 * 提示：
 *   1 <= n, k <= 30
 *   1 <= target <= 1000
 *
 * 【学习要点】分组背包"方案数"问题。
 * 每个骰子是一组，组内 k 个互斥选项（掷出 1..k 点），每组必选一项。
 * dp[j] = 掷出点数和为 j 的方案数，对每个骰子：
 *   for j = target..0（倒序）
 *     dp[j] = Σ dp[j - face]（face = 1..k 且 j - face >= 0）
 * 与 2218 同属分组背包：那题求最优值用 max，这题求方案数用累加。
 * 别忘取模。
 */
public class P20_Solution1155_NumberOfDiceRollsWithTargetSum {

    public int numRollsToTarget(int n, int k, int target) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
