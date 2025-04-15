package com.jnlzw.lzwtool.solutions.ac;
import com.jnlzw.lzwtool.solutions.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution2 {
    List<Integer> list = new ArrayList<Integer>();

    void function(TreeNode root) {
        if (Objects.isNull(root))return;
        if (Objects.nonNull(root.left)) function(root.left);
        list.add(root.val);
        if (Objects.nonNull(root.right)) function(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        function(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1, j = list.size(); i < j; i++) {
            min = Math.min(min, Math.abs((list.get(i) - list.get(i - 1))));
        }
        return min;
    }
}