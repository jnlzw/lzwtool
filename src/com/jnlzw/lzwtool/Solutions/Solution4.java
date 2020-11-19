package com.jnlzw.lzwtool.Solutions;


public class Solution4 {
    TreeNode function(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        int mid = (int) Math.ceil((l + r) * 1. / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left=function(nums,l,mid-1);
        root.right=function(nums,mid+1,r);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return function(nums,0,nums.length-1);
    }
}
