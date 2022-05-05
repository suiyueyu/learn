package me.yzcc.learn.leetcode.no200to300;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
class No215KthLargestElementInAnArray {
    /**
     * 开头想着用大根堆直接全加进来，然后移出去k个，答案就是这个，最后一个，7ms, 40%，比较慢
     * @see https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/javadai-ma-de-2chong-da-an-by-sdwwld/
     * 参考了下别人的，有几种套路，主要是关于排序的
     *
     * <pre>
     * 1. 直接排序，返回第k个
     * 2. 用小根堆，加入数组中的数字，但是在长度到k的时候，就移除最小的，这样，数组里面就是k个最大的。全部加完以后，挪出最小的，就是第k个
     * 试了下这个答案，结果是 6ms，没有明显区别
     * 3. 参考快排的方式，选中一个pivot，把它换到正确的位置。这个时候，pivot左边都小于他，右边都大于他，他就是第k个值
     * 所以放照这个思路，随机选一个，找到他的位置
     * pivot = k，返回
     * pivot < k 左边， pivot > k 右边
     * </pre>
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num: nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        No215KthLargestElementInAnArray solution = new No215KthLargestElementInAnArray();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.findKthLargest(nums, 1));
        System.out.println(solution.findKthLargest(nums, 2));
        System.out.println(solution.findKthLargest(nums, 3));
        System.out.println(solution.findKthLargest(nums, 4));
    }
}
