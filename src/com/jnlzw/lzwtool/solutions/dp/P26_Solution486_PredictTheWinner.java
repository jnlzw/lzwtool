package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 486. 预测赢家（中等）
 *
 * 给你一个整数数组 nums。玩家 1 和玩家 2 轮流从数组的【某一端】
 * 取走一个数字，取走后该数字从数组移除。玩家轮到的次序由玩家 1
 * 开始。两名玩家都采取最优策略，若玩家 1 的最终得分大于等于
 * 玩家 2，返回 true，否则返回 false。
 *
 * 示例 1：
 *   输入：nums = [1, 5, 2]
 *   输出：false
 *   解释：玩家1 只能拿端点。无论拿 1 还是 2，玩家2 都能拿到 5 获胜。
 *
 * 示例 2：
 *   输入：nums = [1, 5, 233, 7]
 *   输出：true
 *   解释：玩家1 拿 1，之后局面变成 [5,233,7] 玩家2 只能拿端点，
 *   玩家1 稳拿 233。
 *
 * 提示：
 *   1 <= nums.length <= 20
 *   0 <= nums[i] <= 10^7
 *
 * 【学习要点】区间 DP + 博弈论。不是背包，但同样是"子问题最优解
 * 拼出全局最优"的思路。dp[i][j] = 区间 nums[i..j] 上【先手】能比
 * 后手多拿的最大分差：
 *   dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])
 * 对手也是最优——你拿 nums[i] 后，留给对手的先手优势是 dp[i+1][j]，
 * 你的净胜 = 拿的 − 对手净胜。按区间长度填表，一格读两格。
 * 答案 dp[0][n-1] >= 0。
 */
public class P26_Solution486_PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        // TODO: 在这里实现你的解法
        return false;
    }
}
