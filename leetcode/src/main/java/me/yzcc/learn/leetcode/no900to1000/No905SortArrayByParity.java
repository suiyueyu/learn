package me.yzcc.learn.leetcode.no900to1000;

/**
 * 905. 按奇偶排序数组
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 *
 * 返回满足此条件的 任一数组 作为答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 * 通过次数104,630提交次数146,765
 */
public class No905SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int lo = 0;
        int hi = nums.length - 1;
        int tmp;

        while (lo <= hi) {
            while (lo <= hi &&(nums[lo] % 2 == 0) ) {
                lo ++;
            }
            while (lo <= hi && (nums[hi] % 2 == 1)) {
                hi --;
            }
            if (lo > hi) {
                break;
            }

            // exchange
            tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo ++;
            hi --;
        }

        return nums;
    }
}