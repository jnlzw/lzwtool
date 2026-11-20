package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 72. 编辑距离（困难）
 *
 * 给你两个单词 word1 和 word2，请返回将 word1 转换成 word2 所使用
 * 的最少操作数。
 *
 * 你可以对一个单词进行如下三种操作：
 *   1. 插入一个字符
 *   2. 删除一个字符
 *   3. 替换一个字符
 *
 * 示例 1：
 *   输入：word1 = "horse", word2 = "ros"
 *   输出：3
 *   解释：
 *     horse -> rorse（将 'h' 替换为 'r'）
 *     rorse -> rose（删除 'r'）
 *     rose -> ros（删除 'e'）
 *
 * 示例 2：
 *   输入：word1 = "intention", word2 = "execution"
 *   输出：5
 *   解释：
 *     intention -> inention（删除 't'）
 *     inention -> enention（将 'i' 替换为 'e'）
 *     enention -> exention（将 'n' 替换为 'x'）
 *     exention -> exection（将 'n' 替换为 'c'）
 *     exection -> execution（插入 'u'）
 *
 * 提示：
 *   0 <= word1.length, word2.length <= 500
 *   word1 和 word2 由小写英文字母组成
 *
 * 【学习要点】编辑距离是双序列 DP 的巅峰之作，与 LCS 一脉相承。
 * dp[i][j] = word1 前 i 个字符变成 word2 前 j 个字符的最少操作数。
 * 字符相等：dp[i][j] = dp[i-1][j-1]
 * 字符不等：min(插入, 删除, 替换) + 1
 * 如果你能独立推出转移方程，二维 DP 就基本通关了。
 */
public class P09_Solution72_EditDistance {

    public int minDistance(String word1, String word2) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
