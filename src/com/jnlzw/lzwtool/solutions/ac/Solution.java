package com.jnlzw.lzwtool.solutions.ac;
public class Solution {

    public int getMaxValue(int[] nums, int[] values) {
        // num.length < values.length

        // num.length = value.length
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j + 1 < nums.length; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j] + nums[j + 1];
                    nums[j + 1] = nums[j] - nums[j + 1];
                    nums[j] = nums[j] - nums[j + 1];
                    values[j] = values[j] + values[j + 1];
                    values[j + 1] = values[j] - values[j + 1];
                    values[j] = values[j] - values[j + 1];
                }
            }
        }
        int result = 0, l = 0, r = values.length - 1;
        for (int num : nums) {
            if (values[l] < values[r]) {
                result += num * values[l];
                l++;
            } else {
                result += num * values[r];
                r--;
            }
        }
        return result;
    }

}
