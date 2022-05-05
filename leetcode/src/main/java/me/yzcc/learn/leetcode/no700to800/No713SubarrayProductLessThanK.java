package me.yzcc.learn.leetcode.no700to800;

public class No713SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (k == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int lastright = -1;
        int mul = 1;

        int result = 0;

        for (; right < nums.length; right++) {

            mul *= nums[right];
            while (left <= right && mul >= k) {
                mul /= nums[left];
                left ++;
            }

            result += (right - left + 1);
        }

        return result;
    }
}