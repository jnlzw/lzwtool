package com.jnlzw.lzwtool.solutions.dp;

import java.util.List;

/**
 * LeetCode 139. 单词拆分（中等）
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用
 * 字典中出现的单词拼接出 s，返回 true。注意：字典中的单词可以
 * 重复使用，不要求全部用上。
 *
 * 示例 1：
 *   输入：s = "leetcode", wordDict = ["leet", "code"]
 *   输出：true
 *
 * 示例 2：
 *   输入：s = "applepenapple", wordDict = ["apple", "pen"]
 *   输出：true
 *
 * 示例 3：
 *   输入：s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 *   输出：false
 *
 * 提示：
 *   1 <= s.length <= 300
 *   1 <= wordDict.length <= 1000
 *   1 <= wordDict[i].length <= 20
 *   s 和 wordDict[i] 仅由小写英文字母组成
 *   wordDict 中的所有字符串互不相同
 *
 * 【学习要点】这不是背包题，但它就是一个完全背包：
 * 字符串 s 是"背包"，单词是"物品"（无限供应、顺序敏感）。
 * dp[j] = s 前 j 个字符能否被拼出；
 * dp[j] = dp[j] || (dp[j - len] && s[j-len..j] == word)。
 * 外层容量、内层物品（同 377 的顺序）——因为拼接是有顺序的。
 */
public class P25_Solution139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        // TODO: 在这里实现你的解法
        return false;
    }
}
