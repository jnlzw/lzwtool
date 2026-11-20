package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 879. 盈利计划（困难）
 *
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。第 i 种
 * 工作会产生 profit[i] 的利润，并要求 group[i] 名员工参与。每项
 * 工作最多完成一次，且同一员工不能同时参与两项工作。
 * 返回能产生至少 minProfit 利润的计划数（计划 = 工作的子集，
 * 总人数不超过 n），答案对 10^9 + 7 取模。
 *
 * 示例 1：
 *   输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 *   输出：2
 *   解释：只做工作1（利润3），或两件都做。
 *
 * 示例 2：
 *   输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 *   输出：7
 *
 * 提示：
 *   1 <= n <= 100
 *   0 <= minProfit <= 100
 *   1 <= group.length <= 100
 *   1 <= group[i] <= 100
 *   profit.length == group.length
 *   0 <= profit[i] <= 100
 *
 * 【学习要点】二维费用 0/1 背包 + 方案数，但难点是"至少 minProfit"。
 * dp[i][j] = 恰好用 i 人、利润【至少】为 j 的方案数——j 只开到
 * minProfit，转移 dp[i][j] += dp[i-g][max(0, j-p)] 把超额利润
 * 全部"钳位"到 j=minProfit 格，避免同一方案按不同利润重复计数。
 * 答案是 Σ dp[i][minProfit]（i 取 0..n），不是单格。
 */
public class P22_Solution879_ProfitableSchemes {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
