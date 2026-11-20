package com.jnlzw.lzwtool.solutions.dp;

/**
 * LeetCode 956. 最高的广告牌（困难）
 *
 * 你正在安装一个广告牌，希望它高度最大。广告牌将有两个钢制支架，
 * 两边相等高度。给你一堆可以焊接在一起的钢筋 rods，返回广告牌
 * 的最大可能安装高度；如果无法安装，返回 0。
 *
 * 示例 1：
 *   输入：rods = [1, 2, 3, 6]
 *   输出：6
 *   解释：一边 {6}，另一边 {1,2,3}，公共高度 6。
 *
 * 示例 2：
 *   输入：rods = [1, 2, 3, 4, 5, 6]
 *   输出：10
 *
 * 示例 3：
 *   输入：rods = [1, 2]
 *   输出：0
 *
 * 提示：
 *   1 <= rods.length <= 20
 *   1 <= rods[i] <= 1000
 *   sum(rods) <= 5000
 *
 * 【学习要点】背包的状态不一定是"容量"。这题把差值当状态：
 * dp[d] = 两边差为 d 时，较长边能达到的最大长度，d ∈ [0, sum]。
 * 每根杆三种选择：不放 / 放高边 / 放矮边：
 *   dp[d+r] = max(dp[d+r], cp[d]+r)          // 放高边
 *   dp[|d-r|] = max(dp[|d-r|], cp[d]+max(r-d,0)) // 放矮边
 * 一次读取写两个格子，必须先用 cp = dp.clone() 快照，不能就地更新。
 * 答案 dp[0]（差为 0 即两边等高）。
 */
public class P23_Solution956_TallestBillboard {

    public int tallestBillboard(int[] rods) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
