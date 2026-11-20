package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 2742. 给墙壁刷油漆（困难）
 *
 * 给你两个长度为 n 的数组 cost 和 time。付费油漆工刷第 i 面墙
 * 收费 cost[i]、耗时 time[i]；同时你还有一个免费油漆工，每单位
 * 时间刷一面墙（只在付费工人干活期间刷，且不重复刷已刷的墙）。
 * 返回刷完 n 面墙的最少花费。
 *
 * 示例 1：
 *   输入：cost = [1, 2, 3, 2], time = [1, 2, 3, 2]
 *   输出：3
 *   解释：付费刷墙0（1元、耗时1，免费工刷1面）和墙3（2元、耗时2，
 *   免费工刷2面），付费2面 + 免费3面 ≥ 4，花费 1+2=3。
 *
 * 示例 2：
 *   输入：cost = [2, 3, 4, 2], time = [1, 1, 1, 1]
 *   输出：4
 *
 * 提示：
 *   cost.length == time.length == n
 *   1 <= n <= 500
 *   1 <= cost[i] <= 10^6
 *   1 <= time[i] <= 500
 *
 * 【学习要点】难在建模，不在 DP。
 * 付费刷墙 i 期间免费工能刷 time[i] 面 → 付费一面等价于
 * "一件重量 time[i]+1、费用 cost[i] 的物品"。
 * 于是变成 0/1 背包求盖满容量 n 的【最小】费用：
 * dp[j] = min(dp[j], dp[max(0, j-w)] + cost)，不可达用 ∞，
 * 读取端要钳位到 0（覆盖超出 n 的部分没有额外价值）。
 */
public class P24_Solution2742_PaintingTheWalls {

    public int paintWalls(int[] cost, int[] time) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
