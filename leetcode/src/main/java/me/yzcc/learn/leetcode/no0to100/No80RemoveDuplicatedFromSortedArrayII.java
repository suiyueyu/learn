package me.yzcc.learn.leetcode.no0to100;

import java.util.Arrays;

/**
 * 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * 通过次数42,690提交次数77,295
 */
class No80RemoveDuplicatedFromSortedArrayII {
    private enum State {
        FIRST,
        SECOND,
        IGNORED
    }
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }

        State state = State.FIRST;
        int count = 1;

        int left = 0;


        for (int right = 1; right < nums.length; right++) {
            if (state == State.FIRST) {
                if (nums[right] == nums[left]) {
                    state = State.SECOND;
                    left ++;
                    nums[left] = nums[right];
                    count ++;
                } else {
                    // FIRST -> FIRST
                    left ++;
                    nums[left] = nums[right];
                    count ++;
                }
            } else if (state == State.SECOND) {
                if (nums[right] == nums[left]) {
                    state = State.IGNORED;
                } else {
                    state = State.FIRST;
                    left ++;
                    nums[left] = nums[right];
                    count ++;
                }
            } else {
                if (nums[right] == nums[left]) {

                } else {
                    state = State.FIRST;
                    left ++;
                    nums[left] = nums[right];
                    count ++;
                }
            }

        }
        return count;

    }

    public static void main(String[] args) {
        No80RemoveDuplicatedFromSortedArrayII solution = new No80RemoveDuplicatedFromSortedArrayII();
        int[] nums1 = new int[] {1,1,1,2,2,3};
        System.out.println(solution.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[] {0,0,1,1,1,1,2,3,3};
        System.out.println(solution.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));

        int[] nums;
        nums = new int[] {1,1,1,1,1,1,1,1,2,2,3};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));


        nums = new int[] {1,2, 3, 4, 5, 6};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1, 1, 2};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1, 2, 2};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1, 2, 2, 3};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
