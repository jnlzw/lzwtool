package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 1143. 最长公共子序列（中等）
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列
 * 的长度。如果不存在公共子序列，返回 0。
 *
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变
 * 字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后
 * 组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的公共子序列是这两个字符串所共同拥有的子序列。
 *
 * 示例 1：
 *   输入：text1 = "abcde", text2 = "ace"
 *   输出：3
 *   解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * 示例 2：
 *   输入：text1 = "abc", text2 = "abc"
 *   输出：3
 *   解释：最长公共子序列是 "abc"，它的长度为 3。
 *
 * 示例 3：
 *   输入：text1 = "abc", text2 = "def"
 *   输出：0
 *   解释：不存在公共子序列。
 *
 * 提示：
 *   1 <= text1.length, text2.length <= 1000
 *   text1 和 text2 仅由小写英文字符组成。
 *
 * 【学习要点】双序列 DP 的模板题，编辑距离、字符串匹配等问题的根基。
 * dp[i][j] = text1 前 i 个字符与 text2 前 j 个字符的 LCS 长度。
 * 字符相等时取左上角 +1，不等时取左/上的最大值。
 * 建议画出 DP 表格手算一遍示例，理解会深刻很多。
 */
public class P08_Solution1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
