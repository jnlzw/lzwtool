package com.jnlzw.lzwtool.solutions.dp;

import com.jnlzw.lzwtool.solutions.TreeNode;

/**
 * LeetCode 337. 打家劫舍 III（中等）
 *
 * 小偷发现了一个新行窃地区，每间房子都是二叉树的一个节点。如果
 * 直接相连的两间房子同一天被打劫，会自动报警。在不触发警报的
 * 情况下，返回小偷一晚能盗取的最大金额。
 *
 * 示例 1：
 *   输入：root = [3, 2, 3, null, 3, null, 1]
 *        3
 *       / \
 *      2   3
 *       \   \
 *        3   1
 *   输出：7
 *   解释：3 + 3 + 1 = 7。
 *
 * 示例 2：
 *   输入：root = [3, 4, 5, 1, 3, null, 1]
 *   输出：9
 *   解释：4 + 5 = 9。
 *
 * 提示：
 *   树的节点数在 [1, 10^4] 范围内
 *   0 <= Node.val <= 10^4
 *
 * 【学习要点】树形 DP——真正的"树上背包"。
 * 每个节点返回两个值：(rob, skip)：
 *   rob  = val + 左skip + 右skip          // 选了，孩子必不选
 *   skip = max(左rob,左skip) + max(右rob,右skip)  // 不选，孩子随意
 * 后序遍历、一次递归带回两个状态。对比背包：物品=节点，
 * "选/不选"的约束从容量换成了父子邻接关系。
 */
public class P27_Solution337_HouseRobberIII {

    public int rob(TreeNode root) {
        // TODO: 在这里实现你的解法
        return 0;
    }
}
