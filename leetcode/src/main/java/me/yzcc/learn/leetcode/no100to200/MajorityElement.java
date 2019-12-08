package me.yzcc.learn.leetcode.no100to200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int length = nums.length;

        Map<Integer, Integer> valueToTimes = new HashMap<>();
        for (int i : nums) {
            int times;

            if (valueToTimes.containsKey(i)) {
                times = valueToTimes.get(i) + 1;
            } else {
                times = 1;
            }
            if (times > length / 2) {
                return i;
            }
            valueToTimes.put(i, times);
        }

        throw new IllegalStateException("should not reach here.");
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);

        // https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/
        // 解法3
        return nums[nums.length / 2];
    }

    // Boyer-Moore 投票算法
    // https://leetcode-cn.com/problems/majority-element/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-4-2/
    // 简单来说，极限一换一，一个众数和一个非众数抵消
    // 因为众数超过一半，最差情况下，数组中众数和非众数交叉，留下最后的是众数
    // 否则，众数会带着优势到最后
}
