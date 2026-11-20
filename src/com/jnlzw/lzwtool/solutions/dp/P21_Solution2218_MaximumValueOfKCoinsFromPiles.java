package com.jnlzw.lzwtool.solutions.dp;

import java.util.List;

/**
 * LeetCode 2218. 从栈中取出 K 个硬币的最大面值和（困难）
 *
 * 桌上总共有 n 个硬币栈，每个栈有若干个硬币，用二维数组 piles
 * 表示，其中 piles[i][j] 表示第 i 个栈自上而下第 j 个硬币的面值。
 * 每一步你可以任选一个栈，取走最上面的硬币。在恰好取 k 次的
 * 前提下，返回你能获得的最大面值和。
 *
 * 示例 1：
 *   输入：piles = [[1,100,3],[7,8,9]], k = 2
 *   输出：101
 *   解释：从栈 0 取 1 和 100，共 101。
 *
 * 示例 2：
 *   输入：piles = [[100],[100],[100],[100],[100],[100],
 *                  [1,1,1,1,1,1,700]], k = 7
 *   输出：706
 *
 * 提示：
 *   n == piles.length，1 <= n <= 1000
 *   1 <= piles[i][j] <= 10^5
 *   1 <= k <= sum(piles[i].length) <= 2000
 *
 * 【学习要点】分组背包。
 * 把每个栈看成"一组"：组内有若干互斥选项（取 0、1、2…个，
 * 代价是取的个数，价值是该栈的前缀和），每组最多选一个选项。
 * dp[j] = 取 j 个硬币的最大价值和，对每个栈：
 *   for j = k..0（倒序容量）
 *     for t = 1..pile.length
 *       dp[j] = max(dp[j], dp[j - t] + prefix[t])
 * 分组背包 = 0/1 背包中"物品"换成了"一组互斥选项"。
 */
public class P21_Solution2218_MaximumValueOfKCoinsFromPiles {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
