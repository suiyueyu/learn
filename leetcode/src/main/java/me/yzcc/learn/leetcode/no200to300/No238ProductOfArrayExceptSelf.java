package me.yzcc.learn.leetcode.no200to300;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 通过次数67,408提交次数95,883
 */
class No238ProductOfArrayExceptSelf {
    /**
     * @see https://leetcode-cn.com/problems/product-of-array-except-self/solution/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/
     *
     * 考虑 a[i] 左侧的乘积 productInLeftSize[i] = a[0]a[1]a[2]...a[i-1]，正好是从0开始，到i-1的累乘。 productInLeftSize[0] = 1，特殊值。
     * a[i] 右侧数字的乘积 productInRightSize[i] = a[i+1]a[i+2]...a[n]，是从右往左的累乘，productInRightSize[n-1] = 1，特殊值。
     *
     * result[i] = productInLeftSize[i] * productInRightSize[i]
     * 这样，只需要做两遍累乘，就能算出结果，且不用除法。
     * 需要两个额外数组
     *
     * 题目说只用O(1)的空间复杂度，但输出不算
     * 可以先拿 result 存 productInLeftSize
     * 然后从n到1，逆序累乘维护一个productInRightSide，就直接和result[i]相乘算出结果
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        if (nums.length == 1) {
            return new int[]{ nums[0] };
        }

        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int productInRightSide = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            productInRightSide *= nums[i + 1];
            result[i] *= productInRightSide;
        }

        return result;
    }
}
