package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 64. 最小路径和（中等）
 *
 * 给定一个包含非负整数的 m x n 网格 grid，请找出一条从左上角到右下角
 * 的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 *   输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 *   输出：7
 *   解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 *   输入：grid = [[1,2,3],[4,5,6]]
 *   输出：12
 *
 * 提示：
 *   m == grid.length
 *   n == grid[i].length
 *   1 <= m, n <= 200
 *   0 <= grid[i][j] <= 200
 *
 * 【学习要点】与"不同路径"同源的二维 DP，但目标从计数变成求最小值。
 * dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])。
 * 思考：能否原地修改 grid 节省空间？边界如何处理？
 */
public class P05_Solution64_MinPathSum {

    public int minPathSum(int[][] grid) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
