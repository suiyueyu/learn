package me.yzcc.learn.leetcode.no200to300;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 通过次数48,390 提交次数113,563
 */
class No209MinimumSizeSubarraySum {

    /**
     * @see https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/javade-jie-fa-ji-bai-liao-9985de-yong-hu-by-sdwwld/
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0) {
            return 0;
        }
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end];
            end ++;

            while (sum >= s) {
                length = Math.min(length, end - start);
                sum -= nums[start];
                start ++;
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
